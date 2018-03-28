package com.yz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author YZ
 * @Date 2018/3/23
 */
@SpringBootApplication
//@SpringBootApplication是一个组合注解，整合了@Configuration，@EnableAutoConfiguration和@ComponentScan注解；组建扫描和自动配置功能
public class ProviderUserApplication {
    public static void main(String [] args){
        SpringApplication.run(ProviderUserApplication.class,args);
    }
}
