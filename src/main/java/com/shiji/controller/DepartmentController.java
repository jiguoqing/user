package com.shiji.controller;

import com.shiji.service.DepartmentService;
import com.shiji.service.model.DepartmentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by jiguoqing on 2019/05/12.
 */
@RestController
@RequestMapping(value = "/employee", produces = "application/json; charset=UTF-8")
public class DepartmentController {

  @Autowired
  private DepartmentService departmentService;

  @GetMapping("/department/findAll")
  public List<DepartmentVO> findAll() {
    List<DepartmentVO> departments = departmentService.findAll();
    return departments;
  }

  @PostMapping("/department/save")
  public String save(@RequestBody DepartmentVO department) {
    if(!departmentService.isExist(department)){
      departmentService.save(department);
      return "true";
    } else {
      return "你录入的部门已经存在";
    }
  }

  @GetMapping("/department/findByName")
  public List<DepartmentVO> findByName(@RequestParam String name) {
    List<DepartmentVO> departments = departmentService.findByName(name);
    return  departments;
  }
  @PostMapping("/department/deleteById")
  public void deleteById(@RequestParam Integer id) {
    departmentService.deleteById(id);
  }
}
