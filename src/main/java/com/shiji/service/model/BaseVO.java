package com.shiji.service.model;

import java.util.Date;

public class BaseVO {
  private static final long serialVersionUID = 1L;
  private Integer id;

  private Date createAt;

  private Date updateAt;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Date getCreateAt() {
    return createAt;
  }

  public void setCreateAt(Date createAt) {
    this.createAt = createAt;
  }

  public Date getUpdateAt() {
    return updateAt;
  }

  public void setUpdateAt(Date updateAt) {
    this.updateAt = updateAt;
  }
}
