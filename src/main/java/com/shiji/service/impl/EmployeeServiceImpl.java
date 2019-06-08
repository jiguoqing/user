package com.shiji.service.impl;

import com.shiji.common.Constans;
import com.shiji.common.ConvertUtil;
import com.shiji.dao.EmployeeMapper;
import com.shiji.dao.dataobject.EmployeeDO;
import com.shiji.service.AssessService;
import com.shiji.service.DepartmentService;
import com.shiji.service.EmployeeService;
import com.shiji.service.model.DepartmentVO;
import com.shiji.service.model.EmployeeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by jiguoqing on 2019/05/12.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

  @Autowired
  private EmployeeMapper employeeMapper;

  @Autowired
  private DepartmentService departmentService;
  @Autowired
  private AssessService assessService;

  @Override
  public List<EmployeeVO> findAll() {
    List<EmployeeDO> employeeDOS = employeeMapper.findAll();
    return ConvertUtil.convertToVOList(employeeDOS, EmployeeVO.class);
  }

  @Override
  public void save(EmployeeVO employee) {
    if (null == employee.getId()) {
      employeeMapper.insert(employee);
    } else {
      employeeMapper.update(employee);
    }
  }

  @Override
  public void deleteById(Integer id) {
    employeeMapper.deleteById(id);
  }

  @Override
  public List<EmployeeVO> findByCondition(Map<String, Object> condition) {
    if (null != condition.get("currentPage")) {
      Integer fromRow =
          (Integer.parseInt(condition.get("currentPage").toString()) - 1) * Constans.pageSize;
      condition.put("fromRow", fromRow);
      condition.put("toRow", fromRow + Constans.pageSize);
    }

    if (null != condition.get("statuses")) {
      condition.put("statuses", Arrays.asList(condition.get("statuses").toString().split(",")));
    }
    if (null != condition.get("month")) {
      Integer month = Integer.parseInt(condition.get("month").toString());

      //如果找一阶段考核的或者没有指定考核阶段的,则入职时间到选择月份满两个月,
      //如果找二阶段考核的,则入职时间到选择月份满两个月,
      //如果找三阶段考核的,则入职时间到选择月份满六个月,
      if (null != condition.get("phase")) {
        Integer phase = Integer.parseInt(condition.get("phase").toString());
        month = month - (phase + 1) * 2;
      } else {
        month = month - 2;
      }
      Calendar cale = null;
      cale = Calendar.getInstance();
      int year = cale.get(Calendar.YEAR);
      int currentMonth = cale.get(Calendar.MONTH);

      cale.set(year, month, 1);
      Date onBoardDate = cale.getTime();
      condition.put("onboardAt", onBoardDate);
    }
    if (null != condition.get("phase")) {
      if ("0".equals(condition.get("phase"))) {
        List<Integer> employeeIds = assessService.findAllEmployeeIds();
        condition.put("idsnotin", employeeIds);
      } else {
        List<Integer> employeeIds = assessService.findEmployIds(condition.get("phase").toString());
        if (CollectionUtils.isEmpty(employeeIds)) {
          return new ArrayList<EmployeeVO>();
        }
        condition.put("ids", employeeIds);
      }
    }
    List<EmployeeDO> employeeDOS = employeeMapper.findByCondition(condition);
    List<EmployeeVO> employeeVOS = new ArrayList<>();
    if (CollectionUtils.isEmpty(employeeDOS)) {
      return employeeVOS;
    }
    List<Integer> ids = new ArrayList<>();
    List<Integer> departmentIds = new ArrayList<>();

    for (EmployeeDO employeeDO : employeeDOS) {
      if (!departmentIds.contains(employeeDO.getDepartmentId())) {
        departmentIds.add(employeeDO.getDepartmentId());
      }
      ids.add(employeeDO.getId());
      employeeVOS.add(ConvertUtil.convertToVO(employeeDO, EmployeeVO.class));
    }
    Map<Integer, String> mapPhase = assessService.findPhase(ids);
    Map<Integer, DepartmentVO> departmentVOMap = departmentService.findByIds(departmentIds);
    for (EmployeeVO employee : employeeVOS) {
      employee.setDepartment(departmentVOMap.get(employee.getDepartmentId()));
      employee.setStatus(Constans.statuses.get(employee.getStatus()));
      if (null != mapPhase) {
        employee.setAssessPhase(Constans.phase.get(mapPhase.get(employee.getId())));
      } else {
        employee.setAssessPhase(Constans.phase.get(null));
      }
    }
    return employeeVOS;
  }

  @Override
  public Integer countByCondition(Map<String, Object> condition) {
    if (null != condition.get("statuses")) {
      condition.put("statuses", Arrays.asList(condition.get("statuses").toString().split(",")));
    }
    if (null != condition.get("phase")) {
      if ("0".equals(condition.get("phase"))) {
        List<Integer> employeeIds = assessService.findAllEmployeeIds();
        condition.put("idsnotin", employeeIds);
      } else {
        List<Integer> employeeIds = assessService.findEmployIds(condition.get("phase").toString());
        if (CollectionUtils.isEmpty(employeeIds)) {
          return 0;
        }
        condition.put("ids", employeeIds);
      }
    }
    return employeeMapper.countByCondition(condition);
  }

  @Override
  public EmployeeVO findById(Integer id) {
    EmployeeDO employeeDO = employeeMapper.findById(id);
    return ConvertUtil.convertToVO(employeeDO, EmployeeVO.class);
  }

  @Override
  public void updataAssessPhaseById(String phase, Integer employeeId) {
    EmployeeDO employeeDO = new EmployeeDO();
    employeeDO.setPhone(phase);
    employeeDO.setId(employeeId);
    employeeMapper.updataAssessPhaseById(employeeDO);
  }
}
