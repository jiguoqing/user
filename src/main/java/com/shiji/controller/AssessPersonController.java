package com.shiji.controller;

import com.shiji.service.AssessPersonService;
import com.shiji.service.model.AssessPersonVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jiguoqing on 2019/05/12.
 */
@RestController
@RequestMapping(value = "", produces = "application/json; charset=UTF-8")
public class AssessPersonController {

  @Autowired
  private AssessPersonService assessPersonService;

  @PostMapping("/assessperson/save")
  public void save(@RequestBody AssessPersonVO assessPersonVO) {
    assessPersonService.save(assessPersonVO);
  }

  @GetMapping("/assessperson/find")
  public AssessPersonVO find(@RequestParam Integer employeeId, @RequestParam String phase) {
    AssessPersonVO assessPersonVO = new AssessPersonVO();
    assessPersonVO.setEmployeeId(employeeId);
    assessPersonVO.setPhase(phase);
    return assessPersonService.find(assessPersonVO);
  }
}
