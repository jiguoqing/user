package com.shiji.dao;

import com.shiji.dao.dataobject.EmployeeDO;
import com.shiji.service.model.EmployeeVO;

import java.util.List;
import java.util.Map;

/**
 * Created by 计国清 on 2019/05/12.
 */
public interface EmployeeMapper {
  List<EmployeeDO> findAll();

  void insert(EmployeeVO employee);

  void update(EmployeeVO employee);

  void deleteById(Integer id);

  List<EmployeeDO> findByCondition(Map<String, Object> condition);

  Integer countByCondition(Map<String, Object> condition);

  EmployeeDO findById(Integer id);

  void updataAssessPhaseById(EmployeeDO employeeDO);
}
