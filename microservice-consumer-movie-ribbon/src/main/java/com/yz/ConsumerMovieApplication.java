package com.yz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Author YZ
 * @Date 2018/3/24
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ConsumerMovieApplication {
    @Bean
    @LoadBalanced//为RestTemplate整合Ribbon使其具备负载均衡的能力
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    public static void main(String[]args){
        SpringApplication.run(ConsumerMovieApplication.class,args);
    }
}
