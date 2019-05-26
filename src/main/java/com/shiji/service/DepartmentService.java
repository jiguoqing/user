package com.shiji.service;

import com.shiji.service.model.DepartmentVO;

import java.util.List;
import java.util.Map;

/**
 * Created by 计国清 on 2019/05/22.
 */
public interface DepartmentService {

  List<DepartmentVO> findAll();

  void save(DepartmentVO department);

  void deleteById(Integer id);

  List<DepartmentVO> findByName(String name);

  Map<Integer, DepartmentVO> findByIds(List<Integer> ids);
}
