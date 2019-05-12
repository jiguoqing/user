package com.shiji.common;

import com.shiji.dao.dataobject.BaseDO;
import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConvertUtil {

  public static <D> D convertToDO(Object voObject, Class<D> doClass) {
    if (null == voObject) {
      return null;
    }
    try {
      D doObject = doClass.newInstance();
      copyProperties(doObject, voObject);
      return doObject;
    } catch (Exception e) {
      return null;
    }
  }

  public static <D> List<D> convertToDOList(List<? extends Object> voList, Class<D> doClass) {
    if (CollectionUtils.isEmpty(voList)) {
      return Collections.emptyList();
    }
    List<D> doList = new ArrayList<D>();
    for (Object vo : voList) {
      doList.add(convertToDO(vo, doClass));
    }
    return doList;
  }

  public static <V> V convertToVO(BaseDO doObject, Class<V> voClass) {
    if (null == doObject) {
      return null;
    }
    try {
      V voObject = voClass.newInstance();
      copyProperties(voObject, doObject);
      return voObject;
    } catch (Exception e) {
      return null;
    }
  }

  public static <V> List<V> convertToVOList(List<? extends BaseDO> doList, Class<V> doClass) {
    if (CollectionUtils.isEmpty(doList)) {
      return Collections.emptyList();
    }
    List<V> voList = new ArrayList<V>();
    for (BaseDO doObject : doList) {
      voList.add(convertToVO(doObject, doClass));
    }
    return voList;
  }

  private static void copyProperties(Object dest, Object orig) {
    try {
      PropertyUtils.copyProperties(dest, orig);
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    }
  }
}
