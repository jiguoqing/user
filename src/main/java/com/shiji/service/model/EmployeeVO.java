package com.shiji.service.model;

import java.util.Date;
/**
 * Created by 计国清 on 2019/05/22.
 */
public class EmployeeVO extends BaseVO {

  private static final long serialVersionUID = 1L;
  private String name;
  private String englishName;
  private String code;
  private Integer departmentId;
  private DepartmentVO department;
  private String jobTitle;
  private String gender;
  private String location;
  private String email;
  private String phone;
  private Date onboardAt;
  private Date phaseOneAt;
  private Date phaseTwoAt;
  private Date phaseThreeAt;
  private Date leavedAt;
  private String level;
  private String status;
  private String assessPhase;

  public Date getPhaseOneAt() {
    return phaseOneAt;
  }

  public void setPhaseOneAt(Date phaseOneAt) {
    this.phaseOneAt = phaseOneAt;
  }

  public Date getPhaseTwoAt() {
    return phaseTwoAt;
  }

  public void setPhaseTwoAt(Date phaseTwoAt) {
    this.phaseTwoAt = phaseTwoAt;
  }

  public Date getPhaseThreeAt() {
    return phaseThreeAt;
  }

  public void setPhaseThreeAt(Date phaseThreeAt) {
    this.phaseThreeAt = phaseThreeAt;
  }

  public String getAssessPhase() {
    return assessPhase;
  }

  public void setAssessPhase(String assessPhase) {
    this.assessPhase = assessPhase;
  }

  public DepartmentVO getDepartment() {
    return department;
  }

  public void setDepartment(DepartmentVO department) {
    this.department = department;
  }

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

  private String description;

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

  public Date getOnboardAt() {
    return onboardAt;
  }

  public void setOnboardAt(Date onboardAt) {
    this.onboardAt = onboardAt;
  }
}
