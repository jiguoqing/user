package com.shiji.dao;

import com.shiji.dao.dataobject.AssessDO;

import java.util.List;
import java.util.Map;

/**
 * Created by 计国清 on 2019/05/12.
 */
public interface AssessMapper {
  List<AssessDO> findByEmployeeId(Integer employedId);

  void insert(AssessDO assess);

  void delete(AssessDO assessDO);

  List<AssessDO> findPhase(List<Integer> employeeIds);
}
