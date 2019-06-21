package com.shiji.service;

import com.shiji.service.model.UserVO;

import java.util.List;
import java.util.Map;

/**
 * Created by 计国清 on 2019/05/12.
 */
public interface UserService {

  void save(UserVO user);

  UserVO find(UserVO user);
}
