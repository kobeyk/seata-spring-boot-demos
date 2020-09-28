package com.appleyk.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * <p>订单服务模块，启动类</p>
 *
 * @author appleyk
 * @version V.0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @github https://github.com/kobeyk
 * @date created on 16:22 2020/9/25
 */

@SpringBootApplication
public class OrderApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class,args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(OrderApplication.class);
    }
}
