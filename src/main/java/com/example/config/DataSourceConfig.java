package com.example.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;


@Configuration
@PropertySource("classpath:/config/db.properties")
@MapperScan("com.example.mapper")
public class DataSourceConfig {

    @Value("${jdbc_driver}")
    private String driverClass;

    @Value("${jdbc_username}")
    private String username;

    @Value("${jdbc_password}")
    private String password;

    @Value("${jdbc_url}")
    private String url;


    @Bean
//    @Profile("anno")
    public DruidDataSource dataSource() {
        System.out.println("username= "+ username);
        DruidDataSource dataSource = new DruidDataSource();
        //dataSource.setDriverClassName(driverClassName);//如果不配置druid会根据url自动识别dbType，然后选择相应的driverClassName
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setValidationQuery("SELECT 1");//用来检测连接是否有效
        dataSource.setTestOnBorrow(false);//申请连接时执行validationQuery检测连接是否有效，做了这个配置会降低性能
        dataSource.setTestOnReturn(false);//归还连接时执行validationQuery检测连接是否有效，做了这个配置会降低性能
        //申请连接的时候检测，如果空闲时间大于timeBetweenEvictionRunsMillis，执行validationQuery检测连接是否有效。
        dataSource.setTestWhileIdle(true);//如果检测失败，则连接将被从池中去除
        dataSource.setTimeBetweenEvictionRunsMillis(600000);
        dataSource.setMaxActive(20);
        dataSource.setInitialSize(10);
        return dataSource;
    }

    @Bean
//    @Profile("anno")
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        // 设置xml的映射文件位置
        sessionFactory.setMapperLocations(resourcePatternResolver.getResources("classpath:mapper/*.xml"));
        // 设置别名的包，可以在xml中直接使用user,
//        sessionFactory.setTypeAliasesPackage("com.demo.sm.entity");
        return sessionFactory.getObject();
    }

   /* @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer configurer = new MapperScannerConfigurer();
        configurer.setBasePackage("com.example.mapper");
        return configurer;
    }*/

}
