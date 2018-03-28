package com.yz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author YZ
 * @Date 2018/3/27
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication {
    public static void main(String[]args){
        SpringApplication.run(EurekaApplication.class,args);
    }
}
