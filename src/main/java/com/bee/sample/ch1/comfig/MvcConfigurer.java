package com.bee.sample.ch1.comfig;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局配置
 */
public class MvcConfigurer implements WebMvcConfigurer {

    /**
     * 增加拦截器
     * @param registry
     */
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new SessionHandlerInterceptor()).addPathPatterns("/admin/**");
    }
}

class SessionHandlerInterceptor implements HandlerInterceptor{
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception{
        return true;
    }
}