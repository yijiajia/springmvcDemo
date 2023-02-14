package com.example.config;

import com.example.convertor.DemoMessageConverter;
import com.example.convertor.LocalDateConverter;
import com.example.convertor.StringToLocalDateFormatter;
import com.example.convertor.StudentConvertor;
import com.example.interceptor.XssInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


import java.util.HashSet;
import java.util.List;
import java.util.Set;


@EnableWebMvc
@Configuration
@ComponentScan(value = "com.example.controller")
public class WebMvcConfig implements WebMvcConfigurer {



    /**
     * 视图解析器的bean配置
     * @return
     */
    @Bean
    public ViewResolver viewResolver() {
        System.out.println("viewResolver init");
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        /**
         * 如果需要在jsp中使用jstl标签的话，需要加上这个视图，且要用这个引用，否则会报找不到方法的500错误
         * 项目中使用JSTL，SpringMVC会把视图由InternalView转换为JstlView。
         * 若使用Jstl的fmt标签，需要在SpringMVC的配置文件中配置国际化资源文件。
         * 需要引入 jstl.jar和standard.jar
         */
//        resolver.setViewClass(org.springframework.web.servlet.view.JstlView.class);
        resolver.setPrefix("/WEB-INF/page/");
        resolver.setSuffix(".jsp");
        resolver.setExposeContextBeansAsAttributes(true);
        return resolver;
    }

    @Bean
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setMaxUploadSize(100 * 1024 * 1024);   // 100M
        return resolver;
    }


    @Bean
    public XssInterceptor initXssInterceptor() {
        return new XssInterceptor();
    }


    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    /**
     * 静态资源的配置
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        System.out.println("addResourceHandlers init....");
        registry.addResourceHandler("/css/**").addResourceLocations("/WEB-INF/statics/css/");
        registry.addResourceHandler("/js/**").addResourceLocations("/WEB-INF/statics/js/");
        registry.addResourceHandler("/image/**").addResourceLocations("WEB-INF/statics/image/");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        WebMvcConfigurer.super.addViewControllers(registry);
    }

    /**
     * 注册拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(initXssInterceptor());
    }

  /*  @Bean
    public LocalDateConverter initDateConverter() {
        return new LocalDateConverter("yyyy-MM-dd");
    }*/

    @Bean
    public StringToLocalDateFormatter stringToLocalDateFormatter() {
        return new StringToLocalDateFormatter("yyyy-MM-dd");
    }

    /**
     * 新增消息处理器
     * @param converters
     */
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(demoMessageConverter());
    }

    @Bean
    public DemoMessageConverter demoMessageConverter() {
        return new DemoMessageConverter();
    }

    /**
     * 新增自定义的类型转换器
     * TODO java 配置如何新增 自定义Convertors
     */
   /* @Bean("conversionService")
    public ConversionServiceFactoryBean initConvertors() {
        ConversionServiceFactoryBean bean = new ConversionServiceFactoryBean();
        Set<Converter> set = new HashSet<>();
        set.add(initDateConverter());
        bean.setConverters(set);
        System.out.println("converter init..");
        return bean;
    }*/

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(stringToLocalDateFormatter());
    }

    /*@Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        WebMvcConfigurer.super.extendMessageConverters(converters);
        converters.add(studentConvertor);
    }*/


}
