package com.shiji.service.impl;

import com.shiji.common.ConvertUtil;
import com.shiji.dao.AssessPersonMapper;
import com.shiji.dao.dataobject.AssessPersonDO;
import com.shiji.service.AssessPersonService;
import com.shiji.service.model.AssessPersonVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jiguoqing on 2019/05/12.
 */
@Service
public class AssessPersonServiceImpl implements AssessPersonService {

  @Autowired
  private AssessPersonMapper assessPersonMapper;

  @Override
  public void save(AssessPersonVO assessPerson) {
    if (assessPerson.getId() == null) {
      assessPersonMapper.insert(ConvertUtil.convertToDO(assessPerson, AssessPersonDO.class));
    } else {
      assessPersonMapper.update(ConvertUtil.convertToDO(assessPerson, AssessPersonDO.class));
    }
  }

  @Override
  public AssessPersonVO find(AssessPersonVO assessPersonVO) {
    AssessPersonDO assessPersonDO =
        assessPersonMapper.find(ConvertUtil.convertToDO(assessPersonVO, AssessPersonDO.class));
    return ConvertUtil.convertToVO(assessPersonDO, AssessPersonVO.class);
  }
}
