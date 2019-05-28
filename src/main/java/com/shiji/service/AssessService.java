package com.shiji.service;

import com.shiji.service.model.AssessVO;

import java.util.List;
import java.util.Map;

/**
 * Created by 计国清 on 2019/05/22.
 */
public interface AssessService {

  List<AssessVO> findByEmployeeId(Integer employeeId);

  void save(AssessVO assess);

  void deleteById(Integer id);

}
