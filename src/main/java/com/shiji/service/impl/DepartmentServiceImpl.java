package com.shiji.service.impl;

import com.shiji.common.ConvertUtil;
import com.shiji.dao.DepartmentMapper;
import com.shiji.dao.dataobject.DepartmentDO;
import com.shiji.service.DepartmentService;
import com.shiji.service.model.DepartmentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jiguoqing on 2019/05/12.
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

  @Autowired
  private DepartmentMapper departmentMapper;

  @Override
  public List<DepartmentVO> findAll() {
    List<DepartmentDO> departmentDOS = departmentMapper.findAll();
    return ConvertUtil.convertToVOList(departmentDOS, DepartmentVO.class);
  }

  @Override
  public void save(DepartmentVO department) {
    if (null == department.getId()) {
      departmentMapper.insert(department);
    } else {
      departmentMapper.update(department);
    }
  }

  @Override
  public void deleteById(Integer id) {
    departmentMapper.deleteById(id);
  }
}
