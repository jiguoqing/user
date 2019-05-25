package com.shiji.dao.dataobject;

import java.util.Date;
/**
 * Created by 计国清 on 2019/05/12.
 */
public class EmployeeDO extends BaseDO {

  private static final long serialVersionUID = 1L;

  private String name;
  private String englishName;
  private String code;
  private Integer departmentId;
  private String jobTitle;
  private String gender;
  private String location;
  private String email;
  private String phone;
  private String description;
  private Date onboardAt;
  private Date leavedAt;
  private String level;
  private String status;

  public Date getLeavedAt() {
    return leavedAt;
  }

  public void setLeavedAt(Date leavedAt) {
    this.leavedAt = leavedAt;
  }

  public String getLevel() {
    return level;
  }

  public void setLevel(String level) {
    this.level = level;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
  public Date getOnboardAt() {
    return onboardAt;
  }

  public void setOnboardAt(Date onboardAt) {
    this.onboardAt = onboardAt;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEnglishName() {
    return englishName;
  }

  public void setEnglishName(String englishName) {
    this.englishName = englishName;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public Integer getDepartmentId() {
    return departmentId;
  }

  public void setDepartmentId(Integer departmentId) {
    this.departmentId = departmentId;
  }

  public String getJobTitle() {
    return jobTitle;
  }

  public void setJobTitle(String jobTitle) {
    this.jobTitle = jobTitle;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }
}
