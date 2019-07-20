package com.shiji.common;

import com.shiji.service.model.AssessVO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Constans {
  public static final int pageSize = 10;

  //Phase one key
  public static final String PHASE_ONE_WORK_ATTITUDE = "PointOne_Working_Attitude";
  public static final String PHASE_ONE_LEARN_ATTITUDE = "PointOne_Learning_Ability";
  public static final String PHASE_ONE_EXPRESSIVE_ATTITUDE = "PointOne_Expressive_Ability";
  public static final String PHASE_ONE_PROBLEM_SOLVE_ATTITUDE = "PointOne_Problem_Solving_Ability";
  public static final String PHASE_ONE_INDUSTRY_KNOWLEDGE = "PointOne_Industry_Knowledge";
  public static final String PHASE_ONE_JOB_RELATED_PRODUCT_KNOWLEDGE_STUDY =
      "PointOne_Job_Related_Product_Knowledge_Study";
  public static final String PHASE_ONE_JOB_RELATED_PRODUCT_KNOWLEDGE_COMPLETE =
      "PointOne_Job_Related_Product_Knowledge_Complete";
  public static final String PHASE_ONE_WORKFLOW = "PointOne_Workflow";
  public static final String PHASE_ONE_TUTOR_SCORING = "PointOne_Tutor_Scoring";
  public static final String PHASE_ONE_SUMMARY = "PointOne_Summary";

  //Phase two key
  public static final String PHASE_TWO_WORK_ATTITUDE_SUMMARY = "PointTwo_Working_Attitude_Summary";
  public static final String PHASE_TWO_WORK_ATTITUDE_LEAD = "PointTwo_Working_Attitude_Lead";
  public static final String PHASE_TWO_LEARN_ATTITUDE_SUMMARY = "PointTwo_Learning_Ability_Summary";
  public static final String PHASE_TWO_LEARN_ATTITUDE_LEAD = "PointTwo_Learning_Ability_Lead";
  public static final String PHASE_TWO_EXPRESSIVE_ATTITUDE_SUMMARY =
      "PointTwo_Expressive_Ability_Summary";
  public static final String PHASE_TWO_EXPRESSIVE_ATTITUDE_LEAD =
      "PointTwo_Expressive_Ability_Lead";
  public static final String PHASE_TWO_COMMUNICATION_ATTITUDE = "PointTwo_Communication_Ability";
  public static final String PHASE_TWO_TRAIN_ATTITUDE = "PointTwo_Train_Ability";
  public static final String PHASE_TWO_PROBLEM_SOLVE_ATTITUDE_SUMMARY =
      "PointTwo_Problem_Solving_Ability_Summary";
  public static final String PHASE_TWO_PROBLEM_SOLVE_ATTITUDE_LEAD =
      "PointTwo_Problem_Solving_Ability_Lead";
  public static final String PHASE_TWO_JOB_RELATED_PRODUCT_KNOWLEDGE_STUDY =
      "PointTwo_Job_Related_Product_Knowledge_Study";
  public static final String PHASE_TWO_JOB_RELATED_PRODUCT_KNOWLEDGE_LEAD =
      "PointTwo_Job_Related_Product_Knowledge_Lead";
  public static final String PHASE_TWO_JOB_RELATED_PRODUCT_KNOWLEDGE_QUALITY =
      "PointTwo_Job_Related_Product_Knowledge_Quality";
  public static final String PHASE_TWO_JOB_RELATED_PRODUCT_KNOWLEDGE_SUMMARY =
      "PointTwo_Job_Related_Product_Knowledge_Summary";
  public static final String PHASE_TWO_WORKFLOW = "PointTwo_Workflow";
  public static final String PHASE_TWO_TUTOR_SCORING = "PointTwo_Tutor_Scoring";
  public static final String PHASE_TWO_SUMMARY = "PointTwo_Summary";
  public static final String PHASE_ONE_RESULT = "PointOne_Result";
  public static final String PHASE_TWO_RESULT = "PointTwo_Result";
  public static final String PHASE_THREE_RESULT = "PointThree_Result";

  //Phase three key
  public static final String PHASE_THREE_WORK_ATTITUDE = "PointThree_Working_Attitude";
  public static final String PHASE_THREE_LEARN_ATTITUDE = "PointThree_Learning_Ability";
  public static final String PHASE_THREE_EXPRESSIVE_ATTITUDE = "PointThree_Expressive_Ability";
  public static final String PHASE_THREE_TRAIN_ATTITUDE = "PointThree_Train_Ability";
  public static final String PHASE_THREE_PROBLEM_SOLVE_ATTITUDE =
      "PointThree_Problem_Solving_Ability";
  public static final String PHASE_THREE_JOB_RELATED_PRODUCT_KNOWLEDGE_USER =
      "PointThree_Job_Related_Product_Knowledge_User";
  public static final String PHASE_THREE_JOB_RELATED_PRODUCT_KNOWLEDGE_SHARE =
      "PointThree_Job_Related_Product_Knowledge_Share";
  public static final String PHASE_THREE_WORKFLOW = "PointThree_Workflow";
  public static final String PHASE_THREE_TUTOR_SCORING = "PointThree_Tutor_Scoring";
  public static final String PHASE_THREE_SUMMARY = "PointThree_Summary";

  public static final Map<String, String> assessType = new LinkedHashMap<>();
  public static final Map<String, String> assessPointOne = new LinkedHashMap<>();
  public static final Map<String, String> assessPointTwo = new LinkedHashMap<>();
  public static final Map<String, String> assessPointThree = new LinkedHashMap<>();
  public static final Map<String, Float> assessPointPercentOne = new LinkedHashMap<>();
  public static final Map<String, Float> assessPointPercentTwo = new LinkedHashMap<>();
  public static final Map<String, Float> assessPointPercentThree = new LinkedHashMap<>();
  public static final Map<String, String> assessStandardOne = new LinkedHashMap<>();
  public static final Map<String, String> assessStandardTwo = new LinkedHashMap<>();
  public static final Map<String, String> assessStandardThree = new LinkedHashMap<>();
  public static final Map<String, String> assessContentOne = new LinkedHashMap<>();
  public static final Map<String, String> assessContentTwo = new LinkedHashMap<>();
  public static final Map<String, String> assessContentThree = new LinkedHashMap<>();
  //
  //  public static final List<String> phaseOneKey = new ArrayList<>();
  //  public static final List<String> phaseTwoKey = new ArrayList<>();
  //  public static final List<String> phaseThreeKey = new ArrayList<>();

  public static final List<AssessVO> assessListOne = new ArrayList<>();
  public static final List<AssessVO> assessListTwo = new ArrayList<>();
  public static final List<AssessVO> assessListThree = new ArrayList<>();
  public static final Map<String, List<AssessVO>> phaseAssess = new HashMap<>();

  public static final Map<String, String> phase = new HashMap<>();
  public static final Map<String, String> statuses = new HashMap<>();
  public static final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

  static {
    initContantsMap();
    initAssessListOne();
    initAssessListTwo();
    initAssessListThree();
  }

  private static void initAssessListOne() {
    for (String key : assessContentOne.keySet()) {
      AssessVO assessVO = new AssessVO();
      assessVO.setContent(assessContentOne.get(key));
      assessVO.setPercent(assessPointPercentOne.get(key));
      assessVO.setPhase("1");
      assessVO.setPoint(assessPointOne.get(key));
      assessVO.setStandard(assessStandardOne.get(key));
      assessVO.setType(key);
      assessListOne.add(assessVO);
    }
  }

  private static void initAssessListTwo() {
    for (String key : assessContentTwo.keySet()) {
      AssessVO assessVO = new AssessVO();
      assessVO.setContent(assessContentTwo.get(key));
      assessVO.setPercent(assessPointPercentTwo.get(key));
      assessVO.setPhase("2");
      assessVO.setPoint(assessPointTwo.get(key));
      assessVO.setStandard(assessStandardTwo.get(key));
      assessVO.setType(key);
      assessListTwo.add(assessVO);
    }
  }

  private static void initAssessListThree() {
    for (String key : assessContentThree.keySet()) {
      AssessVO assessVO = new AssessVO();
      assessVO.setContent(assessContentThree.get(key));
      assessVO.setPercent(assessPointPercentThree.get(key));
      assessVO.setPhase("3");
      assessVO.setPoint(assessPointThree.get(key));
      assessVO.setStandard(assessStandardThree.get(key));
      assessVO.setType(key);
      assessListThree.add(assessVO);
    }
    phaseAssess.put("1", assessListOne);
    phaseAssess.put("2", assessListTwo);
    phaseAssess.put("3", assessListThree);
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

    //考核内容
    assessContentOne.put(PHASE_ONE_WORK_ATTITUDE, "工作态度");
    assessContentOne.put(PHASE_ONE_LEARN_ATTITUDE, "胜任能力");
    assessContentOne.put(PHASE_ONE_EXPRESSIVE_ATTITUDE, "胜任能力");
    assessContentOne.put(PHASE_ONE_PROBLEM_SOLVE_ATTITUDE, "胜任能力");
    assessContentOne.put(PHASE_ONE_INDUSTRY_KNOWLEDGE, "专业技能");
    assessContentOne.put(PHASE_ONE_JOB_RELATED_PRODUCT_KNOWLEDGE_STUDY, "专业技能");
    assessContentOne.put(PHASE_ONE_JOB_RELATED_PRODUCT_KNOWLEDGE_COMPLETE, "专业技能");
    assessContentOne.put(PHASE_ONE_WORKFLOW, "工作流程");
    assessContentOne.put(PHASE_ONE_TUTOR_SCORING, "团队管理评定");
    assessContentOne.put(PHASE_ONE_SUMMARY, "阶段总结");
    assessContentOne.put(PHASE_ONE_RESULT, "评核结果");

    assessContentTwo.put(PHASE_TWO_WORK_ATTITUDE_SUMMARY, "工作态度");
    assessContentTwo.put(PHASE_TWO_WORK_ATTITUDE_LEAD, "工作态度");
    assessContentTwo.put(PHASE_TWO_LEARN_ATTITUDE_SUMMARY, "胜任能力");
    assessContentTwo.put(PHASE_TWO_LEARN_ATTITUDE_LEAD, "胜任能力");
    assessContentTwo.put(PHASE_TWO_EXPRESSIVE_ATTITUDE_SUMMARY, "胜任能力");
    assessContentTwo.put(PHASE_TWO_EXPRESSIVE_ATTITUDE_LEAD, "胜任能力");
    assessContentTwo.put(PHASE_TWO_COMMUNICATION_ATTITUDE, "胜任能力");
    assessContentTwo.put(PHASE_TWO_TRAIN_ATTITUDE, "胜任能力");
    assessContentTwo.put(PHASE_TWO_PROBLEM_SOLVE_ATTITUDE_SUMMARY, "胜任能力");
    assessContentTwo.put(PHASE_TWO_PROBLEM_SOLVE_ATTITUDE_LEAD, "胜任能力");
    assessContentTwo.put(PHASE_TWO_JOB_RELATED_PRODUCT_KNOWLEDGE_STUDY, "专业技能");
    assessContentTwo.put(PHASE_TWO_JOB_RELATED_PRODUCT_KNOWLEDGE_LEAD, "专业技能");
    assessContentTwo.put(PHASE_TWO_JOB_RELATED_PRODUCT_KNOWLEDGE_QUALITY, "专业技能");
    assessContentTwo.put(PHASE_TWO_JOB_RELATED_PRODUCT_KNOWLEDGE_SUMMARY, "专业技能");
    assessContentTwo.put(PHASE_TWO_WORKFLOW, "工作流程");
    assessContentTwo.put(PHASE_TWO_TUTOR_SCORING, "团队管理评定");
    assessContentTwo.put(PHASE_TWO_SUMMARY, "阶段总结");
    assessContentTwo.put(PHASE_TWO_RESULT, "评核结果");

    assessContentThree.put(PHASE_THREE_WORK_ATTITUDE, "工作态度");
    assessContentThree.put(PHASE_THREE_LEARN_ATTITUDE, "胜任能力");
    assessContentThree.put(PHASE_THREE_EXPRESSIVE_ATTITUDE, "胜任能力");
    assessContentThree.put(PHASE_THREE_TRAIN_ATTITUDE, "胜任能力");
    assessContentThree.put(PHASE_THREE_PROBLEM_SOLVE_ATTITUDE, "胜任能力");
    assessContentThree.put(PHASE_THREE_JOB_RELATED_PRODUCT_KNOWLEDGE_USER, "专业技能");
    assessContentThree.put(PHASE_THREE_JOB_RELATED_PRODUCT_KNOWLEDGE_SHARE, "专业技能");
    assessContentThree.put(PHASE_THREE_WORKFLOW, "工作流程");
    assessContentThree.put(PHASE_THREE_TUTOR_SCORING, "团队管理评定");
    assessContentThree.put(PHASE_THREE_SUMMARY, "阶段总结");
    assessContentThree.put(PHASE_THREE_RESULT, "评核结果");

    //评估要点
    assessPointOne.put(PHASE_ONE_WORK_ATTITUDE, "认真和积极的学习、工作态度");
    assessPointOne.put(PHASE_ONE_LEARN_ATTITUDE, "学习能力");
    assessPointOne.put(PHASE_ONE_EXPRESSIVE_ATTITUDE, "表达能力");
    assessPointOne.put(PHASE_ONE_PROBLEM_SOLVE_ATTITUDE, "处理问题能力");
    assessPointOne.put(PHASE_ONE_INDUSTRY_KNOWLEDGE, "行业知识");
    assessPointOne.put(PHASE_ONE_JOB_RELATED_PRODUCT_KNOWLEDGE_STUDY, "岗位相关产品知识");
    assessPointOne.put(PHASE_ONE_JOB_RELATED_PRODUCT_KNOWLEDGE_COMPLETE, "岗位相关产品知识");
    assessPointOne.put(PHASE_ONE_WORKFLOW, "日常工作及项目流程");
    assessPointOne.put(PHASE_ONE_TUTOR_SCORING, "");
    assessPointOne.put(PHASE_ONE_SUMMARY, "");
    assessPointOne.put(PHASE_ONE_RESULT, "总评分");

    assessPointTwo.put(PHASE_TWO_WORK_ATTITUDE_SUMMARY, "认真和积极的学习、工作态度");
    assessPointTwo.put(PHASE_TWO_WORK_ATTITUDE_LEAD, "认真和积极的学习、工作态度");
    assessPointTwo.put(PHASE_TWO_LEARN_ATTITUDE_SUMMARY, "学习能力");
    assessPointTwo.put(PHASE_TWO_LEARN_ATTITUDE_LEAD, "学习能力");
    assessPointTwo.put(PHASE_TWO_EXPRESSIVE_ATTITUDE_SUMMARY, "表达能力");
    assessPointTwo.put(PHASE_TWO_EXPRESSIVE_ATTITUDE_LEAD, "表达能力");
    assessPointTwo.put(PHASE_TWO_COMMUNICATION_ATTITUDE, "沟通能力");
    assessPointTwo.put(PHASE_TWO_TRAIN_ATTITUDE, "培训技能");
    assessPointTwo.put(PHASE_TWO_PROBLEM_SOLVE_ATTITUDE_SUMMARY, "处理问题能力");
    assessPointTwo.put(PHASE_TWO_PROBLEM_SOLVE_ATTITUDE_LEAD, "处理问题能力");
    assessPointTwo.put(PHASE_TWO_JOB_RELATED_PRODUCT_KNOWLEDGE_STUDY, "岗位相关产品知识");
    assessPointTwo.put(PHASE_TWO_JOB_RELATED_PRODUCT_KNOWLEDGE_LEAD, "岗位相关产品知识");
    assessPointTwo.put(PHASE_TWO_JOB_RELATED_PRODUCT_KNOWLEDGE_QUALITY, "岗位相关产品知识");
    assessPointTwo.put(PHASE_TWO_JOB_RELATED_PRODUCT_KNOWLEDGE_SUMMARY, "岗位相关产品知识");
    assessPointTwo.put(PHASE_TWO_WORKFLOW, "项目流程");
    assessPointTwo.put(PHASE_TWO_TUTOR_SCORING, "");
    assessPointTwo.put(PHASE_TWO_SUMMARY, "");
    assessPointTwo.put(PHASE_TWO_RESULT, "总评分");

    assessPointThree.put(PHASE_THREE_WORK_ATTITUDE, "认真和积极的学习、工作态度");
    assessPointThree.put(PHASE_THREE_LEARN_ATTITUDE, "学习能力");
    assessPointThree.put(PHASE_THREE_EXPRESSIVE_ATTITUDE, "表达能力");
    assessPointThree.put(PHASE_THREE_TRAIN_ATTITUDE, "培训技能");
    assessPointThree.put(PHASE_THREE_PROBLEM_SOLVE_ATTITUDE, "处理问题能力");
    assessPointThree.put(PHASE_THREE_JOB_RELATED_PRODUCT_KNOWLEDGE_USER, "岗位相关产品知识");
    assessPointThree.put(PHASE_THREE_JOB_RELATED_PRODUCT_KNOWLEDGE_SHARE, "岗位相关产品知识");
    assessPointThree.put(PHASE_THREE_WORKFLOW, "项目流程");
    assessPointThree.put(PHASE_THREE_TUTOR_SCORING, "");
    assessPointThree.put(PHASE_THREE_SUMMARY, "");
    assessPointThree.put(PHASE_THREE_RESULT, "总评分");

    //评估标准
    assessStandardOne.put(PHASE_ONE_WORK_ATTITUDE, "本阶段评估要点：按时按量保质的发送每日学习报告，阶段性总结报告");
    assessStandardOne.put(PHASE_ONE_LEARN_ATTITUDE, "报告中能体现学习意愿，学习计划，有学习总结");
    assessStandardOne.put(PHASE_ONE_EXPRESSIVE_ATTITUDE, "报告中体现出良好的书面表达能力");
    assessStandardOne.put(PHASE_ONE_PROBLEM_SOLVE_ATTITUDE, "报告中体现出找到问题和处理问题的能力");
    assessStandardOne.put(PHASE_ONE_INDUSTRY_KNOWLEDGE, "EL课程Hotel101相关课程学习情况");
    assessStandardOne.put(PHASE_ONE_JOB_RELATED_PRODUCT_KNOWLEDGE_STUDY, "EL岗位必修课程学习情况");
    assessStandardOne
        .put(PHASE_ONE_JOB_RELATED_PRODUCT_KNOWLEDGE_COMPLETE, "EL岗位必修课程对应练习的完成情况和正确率");
    assessStandardOne.put(PHASE_ONE_WORKFLOW, "参加《新员工入职培训》了解日常工作及项目实施流程并参加考核");
    assessStandardOne.put(PHASE_ONE_TUTOR_SCORING, "由成长导师根据员工在试用期第一阶段期间的日常学习和工作情况作出评分");
    assessStandardOne.put(PHASE_ONE_SUMMARY, "试用期第一阶段学习，工作总结完成情况");

    assessStandardTwo.put(PHASE_TWO_WORK_ATTITUDE_SUMMARY,
        "按时按量保质的发送每日学习报告，Shadow Daily Report，Shadow Summary Report 和阶段性总结报告");
    assessStandardTwo.put(PHASE_TWO_WORK_ATTITUDE_LEAD, "Shadow过程中Leader对工作态度的评估分数");
    assessStandardTwo.put(PHASE_TWO_LEARN_ATTITUDE_SUMMARY, "报告中能体现学习意愿，学习计划，有学习总结。");
    assessStandardTwo.put(PHASE_TWO_LEARN_ATTITUDE_LEAD, "Shadow过程中Leader对学习能力的评估分数");
    assessStandardTwo.put(PHASE_TWO_EXPRESSIVE_ATTITUDE_SUMMARY, "报告中体现出良好的书面表达能力");
    assessStandardTwo.put(PHASE_TWO_EXPRESSIVE_ATTITUDE_LEAD, "Shadow过程中Leader对语言表达能力的评估分数");
    assessStandardTwo.put(PHASE_TWO_COMMUNICATION_ATTITUDE, "Shadow过程中Leader对沟通能力的评估分数");
    assessStandardTwo.put(PHASE_TWO_TRAIN_ATTITUDE, "Shadow过程中Leader对培训技能的评估分数");
    assessStandardTwo.put(PHASE_TWO_PROBLEM_SOLVE_ATTITUDE_SUMMARY, "报告中体现出找到问题和处理问题的能力");
    assessStandardTwo.put(PHASE_TWO_PROBLEM_SOLVE_ATTITUDE_LEAD, "Shadow过程中Leader对处理问题能力的评估分数");
    assessStandardTwo.put(PHASE_TWO_JOB_RELATED_PRODUCT_KNOWLEDGE_STUDY, "EL岗位必修课程学习情况和练习正确率");
    assessStandardTwo
        .put(PHASE_TWO_JOB_RELATED_PRODUCT_KNOWLEDGE_LEAD, "Shadow过程中Leader对产品知识掌握情况的评估分数");
    assessStandardTwo.put(PHASE_TWO_JOB_RELATED_PRODUCT_KNOWLEDGE_QUALITY, "Support Case工作量和质量");
    assessStandardTwo.put(PHASE_TWO_JOB_RELATED_PRODUCT_KNOWLEDGE_SUMMARY, "在EL平台参加岗位产品知识综合性考核");
    assessStandardTwo.put(PHASE_TWO_WORKFLOW, "Shadow过程中Leader对项目流程掌握情况的评估分数");
    assessStandardTwo.put(PHASE_TWO_TUTOR_SCORING, "由成长导师根据员工在试用期第二阶段期间的日常学习和工作情况作出评分");
    assessStandardTwo.put(PHASE_TWO_SUMMARY, "Shadow Summary Report和试用期第二阶段学习，工作总结完成情况");

    assessStandardThree
        .put(PHASE_THREE_WORK_ATTITUDE, "按时按量保质的发送每日学习报告，项目Daliy/Weekly Report，以及阶段性总结报告");
    assessStandardThree.put(PHASE_THREE_LEARN_ATTITUDE, "报告中能体现学习意愿，学习计划，有学习总结。");
    assessStandardThree.put(PHASE_THREE_EXPRESSIVE_ATTITUDE, "口试中表现出良好的语言表达能力。");
    assessStandardThree.put(PHASE_THREE_TRAIN_ATTITUDE, "口试中表现出良好的培训能力。");
    assessStandardThree.put(PHASE_THREE_PROBLEM_SOLVE_ATTITUDE, "口试中当评估人员提出问题，员工表现出理解，处理和解决问题的能力。");
    assessStandardThree.put(PHASE_THREE_JOB_RELATED_PRODUCT_KNOWLEDGE_USER, "用户操作培训（随机1-2个培训内容）");
    assessStandardThree.put(PHASE_THREE_JOB_RELATED_PRODUCT_KNOWLEDGE_SHARE, "问题解决及讲解（随机1-2个问题）");
    assessStandardThree.put(PHASE_THREE_WORKFLOW, "掌握项目各阶段的工作以及遇到问题的处理流程");
    assessStandardThree.put(PHASE_THREE_TUTOR_SCORING, "由部门经理根据员工在试用期期间的日常学习和工作情况作出评分");
    assessStandardThree.put(PHASE_THREE_SUMMARY, "试用期期间的学习，工作总结完成情况（转正报告）");

    //评估百分比
    assessPointPercentOne.put(PHASE_ONE_WORK_ATTITUDE, 5f);
    assessPointPercentOne.put(PHASE_ONE_LEARN_ATTITUDE, 10f);
    assessPointPercentOne.put(PHASE_ONE_EXPRESSIVE_ATTITUDE, 5f);
    assessPointPercentOne.put(PHASE_ONE_PROBLEM_SOLVE_ATTITUDE, 5f);
    assessPointPercentOne.put(PHASE_ONE_INDUSTRY_KNOWLEDGE, 5f);
    assessPointPercentOne.put(PHASE_ONE_JOB_RELATED_PRODUCT_KNOWLEDGE_STUDY, 20f);
    assessPointPercentOne.put(PHASE_ONE_JOB_RELATED_PRODUCT_KNOWLEDGE_COMPLETE, 10f);
    assessPointPercentOne.put(PHASE_ONE_WORKFLOW, 10f);
    assessPointPercentOne.put(PHASE_ONE_TUTOR_SCORING, 20f);
    assessPointPercentOne.put(PHASE_ONE_SUMMARY, 10f);

    assessPointPercentTwo.put(PHASE_TWO_WORK_ATTITUDE_SUMMARY, 2.5f);
    assessPointPercentTwo.put(PHASE_TWO_WORK_ATTITUDE_LEAD, 2.5f);
    assessPointPercentTwo.put(PHASE_TWO_LEARN_ATTITUDE_SUMMARY, 2f);
    assessPointPercentTwo.put(PHASE_TWO_LEARN_ATTITUDE_LEAD, 2f);
    assessPointPercentTwo.put(PHASE_TWO_EXPRESSIVE_ATTITUDE_SUMMARY, 2f);
    assessPointPercentTwo.put(PHASE_TWO_EXPRESSIVE_ATTITUDE_LEAD, 2f);
    assessPointPercentTwo.put(PHASE_TWO_COMMUNICATION_ATTITUDE, 3f);
    assessPointPercentTwo.put(PHASE_TWO_TRAIN_ATTITUDE, 5f);
    assessPointPercentTwo.put(PHASE_TWO_PROBLEM_SOLVE_ATTITUDE_SUMMARY, 2f);
    assessPointPercentTwo.put(PHASE_TWO_PROBLEM_SOLVE_ATTITUDE_LEAD, 2f);
    assessPointPercentTwo.put(PHASE_TWO_JOB_RELATED_PRODUCT_KNOWLEDGE_STUDY, 2f);
    assessPointPercentTwo.put(PHASE_TWO_JOB_RELATED_PRODUCT_KNOWLEDGE_LEAD, 8f);
    assessPointPercentTwo.put(PHASE_TWO_JOB_RELATED_PRODUCT_KNOWLEDGE_QUALITY, 5f);
    assessPointPercentTwo.put(PHASE_TWO_JOB_RELATED_PRODUCT_KNOWLEDGE_SUMMARY, 20f);
    assessPointPercentTwo.put(PHASE_TWO_WORKFLOW, 10f);
    assessPointPercentTwo.put(PHASE_TWO_TUTOR_SCORING, 20f);
    assessPointPercentTwo.put(PHASE_TWO_SUMMARY, 10f);

    assessPointPercentThree.put(PHASE_THREE_WORK_ATTITUDE, 5f);
    assessPointPercentThree.put(PHASE_THREE_LEARN_ATTITUDE, 1f);
    assessPointPercentThree.put(PHASE_THREE_EXPRESSIVE_ATTITUDE, 8f);
    assessPointPercentThree.put(PHASE_THREE_TRAIN_ATTITUDE, 8f);
    assessPointPercentThree.put(PHASE_THREE_PROBLEM_SOLVE_ATTITUDE, 3f);
    assessPointPercentThree.put(PHASE_THREE_JOB_RELATED_PRODUCT_KNOWLEDGE_USER, 17.5f);
    assessPointPercentThree.put(PHASE_THREE_JOB_RELATED_PRODUCT_KNOWLEDGE_SHARE, 17.5f);
    assessPointPercentThree.put(PHASE_THREE_WORKFLOW, 10f);
    assessPointPercentThree.put(PHASE_THREE_TUTOR_SCORING, 20f);
    assessPointPercentThree.put(PHASE_THREE_SUMMARY, 10f);
  }
}
