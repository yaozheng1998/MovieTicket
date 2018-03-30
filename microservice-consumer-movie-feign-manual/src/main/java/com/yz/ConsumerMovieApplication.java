package com.yz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Author YZ
 * @Date 2018/3/24
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ConsumerMovieApplication {
    public static void main(String[]args){
        SpringApplication.run(ConsumerMovieApplication.class,args);
    }
}
