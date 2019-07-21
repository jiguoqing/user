package com.shiji.dao;

import com.shiji.dao.dataobject.AssessPersonDO;

/**
 * Created by 计国清 on 2019/05/12.
 */
public interface AssessPersonMapper {
  void insert(AssessPersonDO assessPersonDO);

  void update(AssessPersonDO assessPersonDO);

  AssessPersonDO find(AssessPersonDO assessPersonDO);
}
