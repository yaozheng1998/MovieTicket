package com.yz;

import com.yz.Model.User;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author YZ
 * @Date 2018/3/29
 */
@FeignClient(name = "microservice-provider-user",configuration = FeignConfiguration.class)
//任意的客户端名称，用于创建Ribbon负载均衡器；使用了Eureka，会把解析成EurekaServer服务注册表中的服务
public interface UserFeignClient {
    /**
     * 使用feign自带的注解@RequestLine
     * @param id
     * @return
     */
    @RequestLine("GET /{id}")
    public User findById(@Param("id") Long id);
}
