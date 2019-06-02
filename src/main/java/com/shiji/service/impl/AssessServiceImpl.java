package com.shiji.service.impl;

import com.shiji.common.Constans;
import com.shiji.common.ConvertUtil;
import com.shiji.dao.AssessMapper;
import com.shiji.dao.dataobject.AssessDO;
import com.shiji.service.AssessService;
import com.shiji.service.EmployeeService;
import com.shiji.service.model.AssessVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by jiguoqing on 2019/05/12.
 */
@Service
public class AssessServiceImpl implements AssessService {

  @Autowired
  private AssessMapper assessMapper;

  @Autowired
  private EmployeeService employeeService;

  @Override
  public List<AssessVO> findByEmployeeId(Integer employeeId) {
    List<AssessDO> assessDOS = assessMapper.findByEmployeeId(employeeId);
    return ConvertUtil.convertToVOList(assessDOS, AssessVO.class);
  }

  @Override
  public void save(Map<String, Object> assessMap) {
    //delete old assess data
    Map<String, Integer> employeeMap = (Map<String, Integer>) assessMap.get("employeeId");
    Integer employeeId = Integer.parseInt(employeeMap.get("employeeId").toString());
    String phase = assessMap.get("phase").toString();
    AssessDO assessDO = new AssessDO();
    assessDO.setEmployeeId(employeeId);
    assessDO.setPhase(phase);
    assessMapper.delete(assessDO);
    //insert new assess data
    Set<String> sets = assessMap.keySet();

    for (String set : sets) {
      if ("employeeId".equals(set)) {
        continue;
      }
      if ("phase".equals(set)) {
        continue;
      }
      AssessDO assess = new AssessDO();
      assess.setEmployeeId(employeeId);
      assess.setPhase(phase);
      assess.setType(set);
      Map<String, Integer> map = (Map) assessMap.get(set);
      assess.setPercent(map.get("percent"));
      assess.setScore(map.get("score"));
      assessMapper.insert(assess);
      //

    }
    employeeService.updataAssessPhaseById(phase, employeeId);
  }

  @Override
  public Map<Integer, String> findPhase(List<Integer> employeeIds) {
    List<AssessDO> assessDOS = assessMapper.findPhase(employeeIds);
    Map<Integer, String> map = new HashMap<>();
    if (CollectionUtils.isEmpty(assessDOS)) {
      return null;
    }
    for (AssessDO assessDO : assessDOS) {
      map.put(assessDO.getEmployeeId(), assessDO.getPhase());
    }
    return map;
  }

  @Override
  public List<AssessVO> find(Integer employeeId, String phase) {
    AssessDO assessDO = new AssessDO();
    assessDO.setEmployeeId(employeeId);
    assessDO.setPhase(phase);
    List<AssessDO> assessDOS = assessMapper.findByCondition(assessDO);
    List<AssessVO> assessVOS = new ArrayList<>();
    for (AssessDO assess : assessDOS) {
      AssessVO assessVO = ConvertUtil.convertToVO(assess, AssessVO.class);
      assessVO.setType(Constans.assessType.get(assessVO.getType()));
      assessVOS.add(assessVO);
    }
    return assessVOS;
  }

  @Override
  public List<Integer> findEmployIds(String phase) {
    List<AssessDO> assessDOS = assessMapper.findByEmployeeIdByPhase(phase);
    List<Integer> employeeIds = new ArrayList<>();
    if (CollectionUtils.isEmpty(assessDOS)) {
      return employeeIds;
    }
    for (AssessDO assessDO : assessDOS) {
      employeeIds.add(assessDO.getEmployeeId());
    }
    return employeeIds;
  }

  @Override
  public List<Integer> findAllEmployeeIds() {
    return assessMapper.findAllEmployeeIds();
  }
}
