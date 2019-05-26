package com.shiji.service.impl;

import com.shiji.common.Constans;
import com.shiji.common.ConvertUtil;
import com.shiji.dao.EmployeeMapper;
import com.shiji.dao.dataobject.EmployeeDO;
import com.shiji.service.DepartmentService;
import com.shiji.service.EmployeeService;
import com.shiji.service.model.DepartmentVO;
import com.shiji.service.model.EmployeeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
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
    Integer fromRow =
        (Integer.parseInt(condition.get("currentPage").toString()) - 1) * Constans.pageSize;
    condition.put("fromRow", fromRow);
    condition.put("toRow", fromRow + Constans.pageSize);

    List<EmployeeDO> employeeDOS = employeeMapper.findByCondition(condition);
    List<EmployeeVO> employeeVOS = new ArrayList<>();
    if (CollectionUtils.isEmpty(employeeDOS)) {
      return employeeVOS;
    }
    List<Integer> ids = new ArrayList<>();

    for (EmployeeDO employeeDO : employeeDOS) {
      ids.add(employeeDO.getDepartmentId());
      employeeVOS.add(ConvertUtil.convertToVO(employeeDO, EmployeeVO.class));
    }
    Map<Integer, DepartmentVO> departmentVOMap = departmentService.findByIds(ids);
    for (EmployeeVO employee : employeeVOS) {
      employee.setDepartment(departmentVOMap.get(employee.getDepartmentId()));
    }
    return employeeVOS;
  }

  @Override
  public Integer countByCondition(Map<String, Object> condition) {
    return employeeMapper.countByCondition(condition);
  }
}
