package com.shiji.controller;

import com.shiji.common.Constans;
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
  public void save(@RequestBody AssessVO assess) {
    assessService.save(assess);
  }

  @GetMapping("/assess/findByEmployeeIdAndPhase")
  public List<AssessVO> findByEmployeeIdAndPhase(@RequestParam Integer employeeId,
      @RequestParam String phase) {
    Map<String, AssessVO> map = assessService.findMap(employeeId, phase);
    List<AssessVO> result = Constans.phaseAssess.get(phase);
    for (AssessVO assess : result) {
      AssessVO target = map.get(assess.getType());
      assess.setEmployeeId(employeeId);
      if (null != target) {
        assess.setPercent(target.getPercent());
        assess.setDescription(target.getDescription());
        assess.setScore(target.getScore());
        assess.setId(target.getId());
        assess.setCreatedAt(target.getCreatedAt());
      }
    }

    if (phase.equals("2") && result.get(1).getScore() != null && result.get(0).getScore() != null) {
      result.get(0).setSummaryScore(result.get(0).getPercent() * result.get(0).getScore()
          + result.get(1).getPercent() * result.get(1).getScore());
    }
    return result;
  }
}
