package com.shiji.api.testMybatis;

import com.shiji.controller.test.TestClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestTests {

  @Test
  public void test() {
    TestClass testClass = new TestClass();
    testClass.test("lilei");
    testClass.test("hanmeimei");
    Assert.assertEquals(1,1);
  }

  @Test
  public void test1() {
    TestClass testClass = new TestClass();
    testClass.test("lilei");
    testClass.test("hanmeimei");
    Assert.assertEquals(1,1);
  }
}
