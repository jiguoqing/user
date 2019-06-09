package com.shiji.controller;

import com.shiji.service.AssessService;
import com.shiji.service.model.AssessVO;
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
//@RequestMapping(value = "/api", produces = "application/json; charset=UTF-8")
@RequestMapping(value = "", produces = "application/json; charset=UTF-8")
public class AssessController {

  @Autowired
  private AssessService assessService;

  @PostMapping("assess/save")
  public void save(@RequestBody Map<String, Object> assess) {
    assessService.save(assess);
  }

  @GetMapping("/assess/findByEmployeeIdAndPhase")
  public List<AssessVO> findByEmployeeIdAndPhase(@RequestParam Integer employeeId,
      @RequestParam String phase) {
    List<AssessVO> assessVOS = assessService.find(employeeId, phase);
    return assessVOS;
  }
}
