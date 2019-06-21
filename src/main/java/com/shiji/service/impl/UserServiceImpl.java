package com.shiji.service.impl;

import com.shiji.common.ConvertUtil;
import com.shiji.dao.UserMapper;
import com.shiji.dao.dataobject.UserDO;
import com.shiji.service.UserService;
import com.shiji.service.model.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jiguoqing on 2019/05/12.
 */
@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserMapper userMapper;

  @Override
  public void save(UserVO user) {
    if (user.getId() != null) {
      userMapper.insert(ConvertUtil.convertToDO(user, UserDO.class));
    } else {
      userMapper.update(ConvertUtil.convertToDO(user, UserDO.class));
    }
  }

  @Override
  public UserVO find(UserVO userVO) {
    return ConvertUtil
        .convertToVO(userMapper.find(ConvertUtil.convertToDO(userVO, UserDO.class)), UserVO.class);
  }
}
