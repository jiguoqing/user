package com.shiji.dao;

import com.shiji.dao.dataobject.AssessDO;
import com.shiji.service.model.AssessVO;

import java.util.List;
import java.util.Map;

/**
 * Created by 计国清 on 2019/05/12.
 */
public interface AssessMapper {
  List<AssessDO> findByEmployeeId(Integer employedId);

  void insert(AssessVO assess);

  void update(AssessVO assess);

  void deleteById(Integer id);
}
