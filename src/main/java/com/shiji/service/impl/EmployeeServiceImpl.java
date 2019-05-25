package com.shiji.service.impl;

import com.shiji.common.Constans;
import com.shiji.common.ConvertUtil;
import com.shiji.dao.EmployeeMapper;
import com.shiji.dao.dataobject.EmployeeDO;
import com.shiji.service.EmployeeService;
import com.shiji.service.model.EmployeeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by jiguoqing on 2019/05/12.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

  @Autowired
  private EmployeeMapper employeeMapper;

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
    return ConvertUtil.convertToVOList(employeeDOS, EmployeeVO.class);
  }

  @Override
  public Integer countByCondition(Map<String, Object> condition) {
    return employeeMapper.countByCondition(condition);
  }
}
