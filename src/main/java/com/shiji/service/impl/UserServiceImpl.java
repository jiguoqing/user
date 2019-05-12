package com.shiji.service.impl;


import com.shiji.dao.UserMapper;
import com.shiji.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jiguoqing on 2018/8/8.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapperDao;

    @Override
    public String getUserName(int stu_id)
    {
        String  name=userMapperDao.getUserNameById(stu_id);
        return name;
    }
}
