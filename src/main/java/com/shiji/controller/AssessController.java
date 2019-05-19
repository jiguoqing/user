package com.shiji.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by jiguoqing on 2019/05/12.
 */
@RestController
@RequestMapping(value = "/oa", produces = "application/json; charset=UTF-8")
public class AssessController {

  @PostMapping("/assess/save")
  public void save(@RequestBody Map<String, Object> assess) {
    System.out.print(assess);
  }
}
