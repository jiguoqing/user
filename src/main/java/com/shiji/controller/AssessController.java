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

    if (phase.equals("1")) {
      result = caculatePhaseOne(result);
    }
    if (phase.equals("2")) {
      result = caculatePhaseTwo(result);
    }
    return result;
  }

  private List<AssessVO> caculatePhaseOne(List<AssessVO> result) {

    Float resultScore = 0F;
    Integer count = 0;
    //计算阶段一评分
    if (result.get(0).getScore() != null) {
      result.get(0).setSummaryScore((result.get(0).getPercent() * result.get(0).getScore()) / 100);
      resultScore = resultScore + result.get(0).getSummaryScore();
      count++;
    }

    if (result.get(1).getScore() != null && result.get(2).getScore() != null
        && result.get(3).getScore() != null) {
      result.get(1).setSummaryScore((result.get(1).getPercent() * result.get(1).getScore()
          + result.get(2).getPercent() * result.get(2).getScore()
          + result.get(3).getPercent() * result.get(3).getScore()) / 100);
      resultScore = resultScore + result.get(1).getSummaryScore();
      count++;
    }
    if (result.get(4).getScore() != null && result.get(5).getScore() != null
        && result.get(6).getScore() != null) {
      result.get(4).setSummaryScore((result.get(4).getPercent() * result.get(4).getScore()
          + result.get(5).getPercent() * result.get(5).getScore()
          + result.get(6).getPercent() * result.get(6).getScore()) / 100);
      resultScore = resultScore + result.get(4).getSummaryScore();
      count++;
    }
    if (result.get(7).getScore() != null) {
      result.get(7).setSummaryScore((result.get(7).getPercent() * result.get(7).getScore()) / 100);
      resultScore = resultScore + result.get(7).getSummaryScore();
      count++;
    }
    if (result.get(8).getScore() != null) {
      result.get(8).setSummaryScore((result.get(8).getPercent() * result.get(8).getScore()) / 100);

      resultScore = resultScore + result.get(8).getSummaryScore();
      count++;
    }
    if (result.get(9).getScore() != null) {
      result.get(9).setSummaryScore((result.get(9).getPercent() * result.get(9).getScore()) / 100);

      resultScore = resultScore + result.get(9).getSummaryScore();
      count++;
    }

    if (count == 6) {
      result.get(10).setSummaryScore(resultScore);
    }
    return result;
  }

  private List<AssessVO> caculatePhaseTwo(List<AssessVO> result) {

    Float resultScore = 0F;
    Integer count = 0;
    //计算阶段二评分
    if (result.get(0).getScore() != null && result.get(1).getScore() != null) {
      result.get(0).setSummaryScore((result.get(0).getPercent() * result.get(0).getScore()
          + result.get(1).getPercent() * result.get(1).getScore()) / 100);
      resultScore = resultScore + result.get(0).getSummaryScore();
      count++;
    }

    if (result.get(2).getScore() != null && result.get(3).getScore() != null) {
      result.get(2).setSummaryScore((result.get(2).getPercent() * result.get(2).getScore()
          + result.get(3).getPercent() * result.get(3).getScore()) / 100);
      resultScore = resultScore + result.get(2).getSummaryScore();
      count++;
    }
    if (result.get(4).getScore() != null && result.get(5).getScore() != null) {
      result.get(4).setSummaryScore((result.get(4).getPercent() * result.get(4).getScore()
          + result.get(5).getPercent() * result.get(5).getScore()) / 100);
      resultScore = resultScore + result.get(4).getSummaryScore();
      count++;
    }
    if (result.get(6).getScore() != null) {
      result.get(6).setSummaryScore((result.get(6).getPercent() * result.get(6).getScore()) / 100);

      resultScore = resultScore + result.get(6).getSummaryScore();
      count++;
    }
    if (result.get(7).getScore() != null) {
      result.get(7).setSummaryScore((result.get(7).getPercent() * result.get(7).getScore()) / 100);
      resultScore = resultScore + result.get(7).getSummaryScore();
      count++;
    }
    if (result.get(8).getScore() != null && result.get(9).getScore() != null) {
      result.get(8).setSummaryScore((result.get(8).getPercent() * result.get(8).getScore()
          + result.get(9).getPercent() * result.get(9).getScore()) / 100);
      resultScore = resultScore + result.get(8).getSummaryScore();
      count++;
    }
    if (result.get(10).getScore() != null && result.get(11).getScore() != null
        && result.get(12).getScore() != null && result.get(13).getScore() != null) {
      result.get(10).setSummaryScore((result.get(10).getPercent() * result.get(10).getScore()
          + result.get(11).getPercent() * result.get(11).getScore()
          + result.get(12).getPercent() * result.get(12).getScore()
          + result.get(13).getPercent() * result.get(13).getScore()) / 100);
      resultScore = resultScore + result.get(10).getSummaryScore();
      count++;
    }

    if (result.get(14).getScore() != null) {
      result.get(14)
          .setSummaryScore((result.get(14).getPercent() * result.get(14).getScore()) / 100);
      resultScore = resultScore + result.get(14).getSummaryScore();
      count++;
    }
    if (result.get(15).getScore() != null) {
      result.get(15)
          .setSummaryScore((result.get(15).getPercent() * result.get(15).getScore()) / 100);
      resultScore = resultScore + result.get(15).getSummaryScore();
      count++;
    }

    if (result.get(16).getScore() != null) {
      result.get(16)
          .setSummaryScore((result.get(16).getPercent() * result.get(16).getScore()) / 100);
      resultScore = resultScore + result.get(16).getSummaryScore();
      count++;
    }

    if (count == 10) {
      result.get(17).setSummaryScore(resultScore);
    }
    return result;
  }
}
