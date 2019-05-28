package com.shiji.service.impl;

import com.shiji.common.ConvertUtil;
import com.shiji.dao.AssessMapper;
import com.shiji.dao.dataobject.AssessDO;
import com.shiji.service.AssessService;
import com.shiji.service.model.AssessVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
  public void save(AssessVO assess) {
    if (null == assess.getId()) {
      assessMapper.insert(assess);
    } else {
      assessMapper.update(assess);
    }
  }

  @Override
  public void deleteById(Integer id) {
    assessMapper.deleteById(id);
  }
}
