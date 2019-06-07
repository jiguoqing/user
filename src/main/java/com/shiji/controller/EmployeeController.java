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

import java.util.List;
import java.util.Map;

/**
 * Created by jiguoqing on 2019/05/12.
 */
@RestController
@RequestMapping(value = "", produces = "application/json; charset=UTF-8")
public class EmployeeController {

  @Autowired
  private EmployeeService employeeService;

  @GetMapping("/employee/findByCondition")
  public List<EmployeeVO> findByCondition(@RequestParam Map<String, Object> condition) {

    List<EmployeeVO> employees = employeeService.findByCondition(condition);
    return employees;
  }

  @GetMapping("/employee/findById")
  public EmployeeVO findById(@RequestParam Integer id) {
    return employeeService.findById(id);
  }

  @GetMapping("/employee/countByCondition")
  public Integer countByCondition(@RequestParam Map<String, Object> condition) {
    return employeeService.countByCondition(condition);
  }

  @PostMapping("/employee/save")
  public void save(@RequestBody EmployeeVO employee) {
    employeeService.save(employee);
  }

  @PostMapping("/employee/deleteById")
  public void deleteById(@RequestParam Integer id) {
    employeeService.deleteById(id);
  }
}
