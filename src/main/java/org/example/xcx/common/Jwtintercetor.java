package org.example.xcx.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Jwtintercetor implements HandlerInterceptor {
    @Autowired
    private JwtUtil jwtUtil;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
        System.out.println(request.getRequestURI()+"进入拦截器了");
        String Authorization=request.getHeader("Authorization");

        try {
            String userId = jwtUtil.verifyToken(Authorization);
            request.setAttribute("userId", userId);
        } catch (Exception e) {
            response.setStatus(401);
            return false;
        }

        //中间写逻辑代码，比如判断是否登录成功，失败则返回false
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {

    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

    }
}
