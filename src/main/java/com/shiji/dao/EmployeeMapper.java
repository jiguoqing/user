package com.shiji.dao;

import com.shiji.dao.dataobject.EmployeeDO;
import com.shiji.service.model.EmployeeVO;

import java.util.List;

/**
 * Created by 计国清 on 2019/05/12.
 */
public interface EmployeeMapper {
  List<EmployeeDO> findAll();

  void insert(EmployeeVO employee);

  void update(EmployeeVO employee);

  void deleteById(Integer id);
}
