package com.shiji.controller;

import com.shiji.service.EmployeeService;
import com.shiji.service.model.EmployeeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * Created by jiguoqing on 2019/05/12.
 */
@RestController
@RequestMapping(value = "/oa", produces = "application/json; charset=UTF-8")
public class EmployeeController {

  @Autowired
  private EmployeeService employeeService;

  @GetMapping("/employee/findByCondition")
  public List<EmployeeVO> findAll(@RequestParam String page, @RequestParam String pageSize) {

    List<EmployeeVO> employees = employeeService.findAll();
    return employees;
  }

  @PostMapping("/employee/save")
  public void save(@RequestBody EmployeeVO employee) {
    employeeService.save(employee);
  }
}
