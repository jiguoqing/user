package com.shiji.service.model;

/**
 * Created by 计国清 on 2019/05/22.
 */
public class UserVO extends BaseVO {

  private static final long serialVersionUID = 1L;
  private String name;
  private String password;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
