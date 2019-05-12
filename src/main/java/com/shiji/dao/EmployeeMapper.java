package com.shiji.dao;

import com.shiji.dao.dataobject.EmployeeDO;

import java.util.List;

/**
 * Created by jiguoqing on 2019/05/12.
 */
public interface EmployeeMapper {
  List<EmployeeDO> findAll();
}
