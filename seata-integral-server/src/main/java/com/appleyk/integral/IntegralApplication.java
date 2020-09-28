package com.appleyk.integral;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * <p>业务操作入口，启动类</p>
 *
 * @author appleyk
 * @version V.0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @github https://github.com/kobeyk
 * @date created on 16:19 2020/9/25
 */

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class IntegralApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(IntegralApplication.class,args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(IntegralApplication.class);
    }
}
