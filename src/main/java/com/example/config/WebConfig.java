package com.example.config;

import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;

/**
 * 代替 web.xml配置的 Java配置
 */
public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * bean配置的配置类
     * @return
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        System.out.println("getRootConfigClasses 。。。。。");
        return new Class<?>[] {ApplicationContextConfig.class};
    }

    /**
     * DispatcherServlet 的配置类，如本应用的 springmvc.xml
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] {WebMvcConfig.class};
    }

    /**
     * servlet的映射路径
     * @return
     */
    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"}; // 映射根目录以下的路径，即全路径
    }





}
