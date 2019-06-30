package com.shiji.conf;

import com.shiji.service.UserService;
import com.shiji.service.model.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor {

  @Autowired
  private UserService userService;

  /*
   * 进入controller层之前拦截请求
   * 返回值：表示是否将当前的请求拦截下来  false：拦截请求，请求别终止。true：请求不被拦截，继续执行
   * Object obj:表示被拦的请求的目标对象（controller中方法）
   */
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws IOException {
    System.out.println("执行到了preHandle方法");
//    System.out.println(handler);
    Cookie[] cookies = request.getCookies();
    if (!authorized(cookies)) {
      //      response.sendRedirect(request.getContextPath() + "login");//拦截后跳转的方法
      System.out.println("已成功拦截并转发跳转");
      response.setStatus(403);
      return false;
    }

    System.out.println("合格不需要拦截，放行");
    return true;
  }

  private boolean authorized(Cookie[] cookies) {
    if (cookies == null) {
      return false;
    }
    Map map = new HashMap();
    for (Cookie cookie : cookies) {
      map.put(cookie.getName(), cookie.getValue());
    }
    if (map.get("username") == null || map.get("password") == null) {
      return false;
    }

    UserVO userVO = new UserVO();
    userVO.setName(map.get("username").toString());
    userVO.setPassword(map.get("password").toString());
    return (null != userService.find(userVO));
  }

  /*
   * 处理请求完成后视图渲染之前的处理操作
   * 通过ModelAndView参数改变显示的视图，或发往视图的方法
   */
  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
      ModelAndView modelAndView) {
    System.out.println("执行了postHandle方法");
  }

  /*
   * 视图渲染之后的操作
   */
  @Override
  public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2,
      Exception arg3) throws Exception {
    System.out.println("执行到了afterCompletion方法");
  }
}