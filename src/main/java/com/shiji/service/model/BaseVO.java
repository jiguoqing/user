package com.shiji.service.model;

import java.util.Date;

/**
 * Created by 计国清 on 2019/05/22.
 */
public class BaseVO {
  private static final long serialVersionUID = 1L;
  private Integer id;

  private Date createdAt;

  private Date updatedAt;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public Date getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }
}
