package com.shiji.dao;

import com.shiji.dao.dataobject.UserDO;

/**
 * Created by 计国清 on 2019/05/12.
 */
public interface UserMapper {
  void insert(UserDO user);

  void update(UserDO user);

  UserDO find(UserDO user);
}
