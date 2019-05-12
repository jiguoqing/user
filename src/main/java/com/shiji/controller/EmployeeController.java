package com.shiji.controller;

import com.shiji.dao.UserMapper;
import com.shiji.service.EmployeeService;
import com.shiji.service.model.EmployeeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by jiguoqing on 2019/05/12.
 */
@RestController
@RequestMapping(value = "/shiji", produces = "application/json; charset=UTF-8")
public class EmployeeController {

  @Autowired
  private EmployeeService employeeService;
  @Autowired
  private UserMapper userMapperDao;

  @GetMapping("/employee/findAll")
  public List<EmployeeVO> findAll() {

    List<EmployeeVO> employees = employeeService.findAll();

    return  employees;
  }
}
