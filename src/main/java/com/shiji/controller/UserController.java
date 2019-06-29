package com.shiji.controller;

import com.shiji.service.UserService;
import com.shiji.service.model.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jiguoqing on 2019/05/12.
 */
@RestController
@RequestMapping(value = "", produces = "application/json; charset=UTF-8")
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping("/user/validate")
  public Boolean validate(@RequestBody UserVO userVO) {
    return userService.find(userVO) != null;
  }

//  @GetMapping("/user/validate")
//  public Boolean validate(@RequestParam String user, @RequestParam String password) {
//
//    UserVO userVO = new UserVO();
//    userVO.setName(user);
//    userVO.setPassword(password);
//    return  userService.find(userVO) != null;
//  }
}
