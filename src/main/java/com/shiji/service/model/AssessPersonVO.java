package com.shiji.service.model;

/**
 * Created by 计国清 on 2019/07/22.
 */
public class AssessPersonVO extends BaseVO {

  private static final long serialVersionUID = 1L;
  private String phase;
  private Integer employeeId;
  private String name;

  public String getPhase() {
    return phase;
  }

  public void setPhase(String phase) {
    this.phase = phase;
  }

  public Integer getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(Integer employeeId) {
    this.employeeId = employeeId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
