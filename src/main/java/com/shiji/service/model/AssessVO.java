package com.shiji.service.model;

/**
 * Created by 计国清 on 2019/05/22.
 */
public class AssessVO extends BaseVO {

  private static final long serialVersionUID = 1L;
  private String phase;
  private Integer employeeId;
  private Integer score;
  private Float percent;
  private String type;
  private String description;
  private String content;
  private String point;
  private String standard;
  private Float summaryScore;

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getPoint() {
    return point;
  }

  public void setPoint(String point) {
    this.point = point;
  }

  public String getStandard() {
    return standard;
  }

  public void setStandard(String standard) {
    this.standard = standard;
  }

  public Float getSummaryScore() {
    return summaryScore;
  }

  public void setSummaryScore(Float summaryScore) {
    this.summaryScore = summaryScore;
  }

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

  public Float getPercent() {
    return percent;
  }

  public void setPercent(Float percent) {
    this.percent = percent;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
