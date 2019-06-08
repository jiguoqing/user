package com.shiji.controller;

import static org.springframework.http.HttpHeaders.CONTENT_DISPOSITION;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;

import com.shiji.common.Constans;
import com.shiji.common.ExcelUtil;
import com.shiji.service.EmployeeService;
import com.shiji.service.model.EmployeeVO;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by jiguoqing on 2019/05/12.
 */
@RestController
@RequestMapping(value = "/api", produces = "application/json; charset=UTF-8")
public class EmployeeController {

  @Autowired
  private EmployeeService employeeService;

  @GetMapping("/employee/findByCondition")
  public List<EmployeeVO> findByCondition(@RequestParam Map<String, Object> condition) {

    List<EmployeeVO> employees = employeeService.findByCondition(condition);
    return employees;
  }

  @GetMapping("/employee/findById")
  public EmployeeVO findById(@RequestParam Integer id) {
    return employeeService.findById(id);
  }

  @GetMapping("/employee/countByCondition")
  public Integer countByCondition(@RequestParam Map<String, Object> condition) {
    return employeeService.countByCondition(condition);
  }

  @PostMapping("/employee/save")
  public void save(@RequestBody EmployeeVO employee) {
    employeeService.save(employee);
  }

  @PostMapping("/employee/deleteById")
  public void deleteById(@RequestParam Integer id) {
    employeeService.deleteById(id);
  }

  @GetMapping("/employee/assess/exportExcel")
  public void exportExcel(HttpServletRequest request, HttpServletResponse response,
      @RequestParam String phase, @RequestParam String month) {

    Map<String, Object> map = new HashMap<>();
    if (!StringUtils.isEmpty(phase) && !"undefined".equals(phase)) {
      map.put("phase", phase);
    }
    if (!StringUtils.isEmpty(month) && !"undefined".equals(month)) {
      map.put("month", month);
    }
    List<EmployeeVO> list = employeeService.findByCondition(map);
    String fileName = "assess";
    String attachment = "attachment;filename=" + fileName + ".xls";
    HSSFWorkbook wb = ExcelUtil.getFWorkbook(fileName, getHeadList(), convertToContent(list));

    response.setContentType(CONTENT_TYPE);
    response.setHeader(CONTENT_DISPOSITION, attachment);
    try (OutputStream os = response.getOutputStream()) {
      wb.write(os);
      os.flush();
    } catch (IOException exception) {
      throw new IllegalStateException(exception);
    }
  }

  private List<List<String>> convertToContent(List<EmployeeVO> employees) {

    List<List<String>> contentList = new ArrayList<>();
    for (EmployeeVO employee : employees) {
      List<String> row = new ArrayList<>();
      row.add(employee.getName());
      row.add(employee.getEnglishName());
      row.add(employee.getGender());
      row.add(employee.getCode());
      row.add(employee.getJobTitle());
      row.add(employee.getLevel());
      row.add(employee.getEmail());
      row.add(employee.getPhone());
      row.add(employee.getOnboardAt() != null ?
          Constans.formatter.format(employee.getOnboardAt()) :
          "未填写");
      row.add(employee.getStatus());
      if (null != employee.getDepartment()) {
        row.add(employee.getDepartment().getName());
      }
      row.add(employee.getAssessPhase());
      row.add(employee.getLocation());
      row.add(employee.getDescription());

      contentList.add(row);
    }
    return contentList;
  }

  private List<String> getHeadList() {
    List<String> headList = new ArrayList<>();
    headList.add("姓名");
    headList.add("英文名");
    headList.add("性别");
    headList.add("员工号");
    headList.add("职位");
    headList.add("层级");
    headList.add("email");
    headList.add("手机");
    headList.add("入职日期");
    headList.add("状态");
    headList.add("部门");
    headList.add("考核阶段");
    headList.add("办公地");
    headList.add("描述");
    return headList;
  }
}
