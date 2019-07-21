package com.shiji.service;

import com.shiji.service.model.AssessPersonVO;

/**
 * Created by 计国清 on 2019/05/12.
 */
public interface AssessPersonService {

  void save(AssessPersonVO assessPerson);

  AssessPersonVO find(AssessPersonVO assessPerson);
}
