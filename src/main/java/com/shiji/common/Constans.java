package com.shiji.common;

import java.util.HashMap;
import java.util.Map;

public class Constans {
  public static final int pageSize = 10;
  public static final Map<String, String> assessType = new HashMap<>();
  public static final Map<String, String> phase = new HashMap<>();

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
  }
}
