package com.shiji.dao.dataobject;

/**
 * Created by 计国清 on 2019/05/22.
 */
public class AssessDO extends BaseDO {

  private static final long serialVersionUID = 1L;
  private String phase;
  private Integer employeeId;
  private Integer score;
  private Integer percent;
  private String type;
  private String decription;

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

  public Integer getScore() {
    return score;
  }

  public void setScore(Integer score) {
    this.score = score;
  }

  public Integer getPercent() {
    return percent;
  }

  public void setPercent(Integer percent) {
    this.percent = percent;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getDecription() {
    return decription;
  }

  public void setDecription(String decription) {
    this.decription = decription;
  }
}
