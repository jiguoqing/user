package com.shiji.service;

import com.shiji.service.model.AssessVO;

import java.util.List;
import java.util.Map;

/**
 * Created by 计国清 on 2019/05/22.
 */
public interface AssessService {

  List<AssessVO> findByEmployeeId(Integer employeeId);

  void save(AssessVO assessVO);

  Map<Integer, String> findPhase(List<Integer> employeeIds);

  List<AssessVO> find(Integer employeeId, String phase);

  /**
   *
   * @param employeeId
   * @param phase
   * @return key: type
   */
  Map<String,AssessVO> findMap(Integer employeeId, String phase);

  List<Integer> findEmployIds(String phase);

  List<Integer> findAllEmployeeIds();
}
