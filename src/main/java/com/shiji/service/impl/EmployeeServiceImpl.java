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
import java.util.HashMap;
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
    Map<String, String> phase = new HashMap<>();
    phase.put("1", "阶段一");
    phase.put("2", "阶段二");
    phase.put("3", "阶段三");
    phase.put(null, "未考核");
    Integer fromRow =
        (Integer.parseInt(condition.get("currentPage").toString()) - 1) * Constans.pageSize;
    condition.put("fromRow", fromRow);
    condition.put("toRow", fromRow + Constans.pageSize);

    if (null != condition.get("statuses")) {
      condition.put("statuses", Arrays.asList(condition.get("statuses").toString().split(",")));
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
    //    Map<Integer,String> assessResult = new HashMap<>();
    //    Map<Integer,List<AssessVO>> mapAssessList = new HashMap<>();
    //    List<AssessVO> assessVOS = assessService.findByIds(ids);
    //    for(AssessVO assess:assessVOS){
    //        if(CollectionUtils.isEmpty(mapAssessList.get(assess.getEmployeeId()))){
    //
    //            mapAssessList.put(assess.getEmployeeId(),new Arrays.to(assess));
    //        }
    //
    //    }
    Map<Integer, DepartmentVO> departmentVOMap = departmentService.findByIds(departmentIds);
    for (EmployeeVO employee : employeeVOS) {
      employee.setDepartment(departmentVOMap.get(employee.getDepartmentId()));
      if (null != mapPhase) {
        employee.setAssessPhase(phase.get(mapPhase.get(employee.getId())));
      }
    }
    return employeeVOS;
  }

  @Override
  public Integer countByCondition(Map<String, Object> condition) {
    if (null != condition.get("statuses")) {
      condition.put("statuses", Arrays.asList(condition.get("statuses").toString().split(",")));
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
