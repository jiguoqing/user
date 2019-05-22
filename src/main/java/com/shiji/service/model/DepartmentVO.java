package com.shiji.service.model;

import com.shiji.dao.dataobject.BaseDO;

/**
 * Created by 计国清 on 2019/05/22.
 */
public class DepartmentVO extends BaseDO {

  private static final long serialVersionUID = 1L;

  private String name;
  private String description;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getOwner() {
    return owner;
  }

  public void setOwner(String owner) {
    this.owner = owner;
  }

  private String owner;
}
