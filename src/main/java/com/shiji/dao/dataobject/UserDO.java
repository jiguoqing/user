package com.shiji.dao.dataobject;

/**
 * Created by 计国清 on 2019/05/12.
 */
public class UserDO extends BaseDO {

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
