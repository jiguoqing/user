package com.shiji.service.impl;

import com.shiji.common.ConvertUtil;
import com.shiji.dao.AssessMapper;
import com.shiji.dao.dataobject.AssessDO;
import com.shiji.service.AssessService;
import com.shiji.service.model.AssessVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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

  @Override
  public List<AssessVO> findByEmployeeId(Integer employeeId) {
    List<AssessDO> assessDOS = assessMapper.findByEmployeeId(employeeId);
    return ConvertUtil.convertToVOList(assessDOS, AssessVO.class);
  }

  @Override
  public void save(Map<String, Object> assessMap) {
    //delete old assess data
    Map<String,Integer> employeeMap = (Map<String, Integer>) assessMap.get("employeeId");
    Integer employeeId = Integer.parseInt(employeeMap.get("employeeId").toString());
    String phase = assessMap.get("phase").toString();
    AssessDO assessDO = new AssessDO();
    assessDO.setEmployeeId(employeeId);
    assessDO.setPhase(phase);
    assessMapper.delete(assessDO);
    //insert new assess data
    Set<String> sets =  assessMap.keySet();

    for (String set:sets) {
      if("employeeId".equals(set)){
        continue;
      }
      if("phase".equals(set)){
        continue;
      }
      AssessDO assess = new AssessDO();
      assess.setEmployeeId(employeeId);
      assess.setPhase(phase);
      assess.setType(set);
      Map<String,Integer> map = (Map) assessMap.get(set);
      assess.setPercent(map.get("percent"));
      assess.setScore(map.get("score"));
      assessMapper.insert(assess);
      System.out.print(assess);
    }
  }
}
