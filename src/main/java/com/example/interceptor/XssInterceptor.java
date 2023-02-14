package com.example.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@Component
@Slf4j
public class XssInterceptor extends HandlerInterceptorAdapter {

    /**
     * 请求前处理
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("拦截器前置方法");
        long beginTime = System.currentTimeMillis();
        request.setAttribute("beginTime",beginTime);
        return super.preHandle(request, response, handler);
    }

    /**
     * 请求后处理
     * @param request
     * @param response
     * @param handler  执行方法
     * @param modelAndView 模型视图
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        long beginTime = (Long)request.getAttribute("beginTime");

        request.removeAttribute("beginTime");

        log.info("请求耗时 :" + (System.currentTimeMillis() - beginTime) );

    }
}
