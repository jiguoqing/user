package com.shiji.service;

import com.shiji.service.model.EmployeeVO;

import java.util.List;
import java.util.Map;

/**
 * Created by 计国清 on 2019/05/12.
 */
public interface EmployeeService {

  List<EmployeeVO> findAll();

  void save(EmployeeVO employee);

  void deleteById(Integer id);

  List<EmployeeVO> findByCondition(Map<String, Object> condition);

  Integer countByCondition(Map<String, Object> condition);
}
