package com.shiji.service;

import com.shiji.service.model.EmployeeVO;

import java.util.List;

/**
 * Created by jiguoqing on 2019/05/12.
 */
public interface EmployeeService {

  List<EmployeeVO> findAll();

  void save(EmployeeVO employee);
}
