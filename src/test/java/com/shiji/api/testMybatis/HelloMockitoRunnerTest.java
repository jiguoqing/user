package com.shiji.api.testMybatis;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import com.shiji.controller.test.Hello;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.testng.Assert;

/**
 * There are 3 ways to mock one object via annotation (@Mock).
 * <p>
 * And, have 1 way to mock the object via API (Mockito.mock) directly.
 *
 * @author 计国清
 */
@RunWith(MockitoJUnitRunner.class) // 1. runner way
public class HelloMockitoRunnerTest {
  @Mock
  Hello hello;

  //     2. init way
//  @Before
//  public void setup() {
//    MockitoAnnotations.initMocks(this);
//  }
//
//  //     3. rule way
//  @Rule
//  public MockitoRule mockito = MockitoJUnit.rule();

  @Test
  public void testSayHello() {
    // hello = mock(Hello.class); //4. API way
    when(hello.sayHello("world")).thenReturn("Hi");
    assertThat(hello.sayHello("world"), is("Hi"));
    Assert.assertEquals(hello.sayHello("world"),"hello");
  }
}
