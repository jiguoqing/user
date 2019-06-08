package com.shiji.common;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

public class Constans {
  public static final int pageSize = 10;
  public static final Map<String, String> assessType = new HashMap<>();
  public static final Map<String, String> phase = new HashMap<>();
  public static final Map<String, String> statuses = new HashMap<>();
  public static final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

  static {
    initContantsMap();
  }

  private static void initContantsMap() {
    assessType.put("performance", "业绩");
    assessType.put("ability", "工作能力");

    phase.put("1", "阶段一");
    phase.put("2", "阶段二");
    phase.put("3", "阶段三");
    phase.put(null, "未考核");

    statuses.put("TRIAL", "试用期");
    statuses.put("ON_DUTY", "在职");
    statuses.put("LEAVE", "离职");
  }
}
