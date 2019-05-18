package com.shiji.dao.dataobject;

import java.util.Date;

public class EmployeeDO extends BaseDO {

  private static final long serialVersionUID = 1L;

  private String name;
  private String englishName;
  private String code;
  private String department;
  private String jobTitle;
  private String gender;
  private String location;
  private String email;
  private String phone;
  private String description;
  private Date onboardAt;

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

  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
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
