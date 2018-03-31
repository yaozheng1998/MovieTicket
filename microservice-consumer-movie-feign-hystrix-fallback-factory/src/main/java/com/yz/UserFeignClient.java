package com.yz;

import com.yz.Model.User;
import feign.Logger;
import feign.hystrix.FallbackFactory;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author YZ
 * @Date 2018/3/29
 */
@FeignClient(name = "microservice-provider-user",fallbackFactory = UserFeignClient.FeignClientFallbackFactory.class)
//任意的客户端名称，用于创建Ribbon负载均衡器；使用了Eureka，会把解析成EurekaServer服务注册表中的服务
public interface UserFeignClient {
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public User findById(@PathVariable("id") Long id);

    /**
     * UserFeignClient的fallbackFactory类，该类需实现FallbackFactory接口，并覆写create方法
     */
    @Component
    class FeignClientFallbackFactory implements FallbackFactory<UserFeignClient>{
        private static final org.slf4j.Logger LOGGER= LoggerFactory.getLogger(FeignClientFallbackFactory.class);
        @Override
        public UserFeignClient create(Throwable throwable) {
            return new UserFeignClient() {
                @Override
                public User findById(Long id) {
                    FeignClientFallbackFactory.LOGGER.info("fallback;reason was:",throwable);
                    User user=new User();
                    user.setId(-1L);
                    user.setUsername("默认用户");
                    return user;
                }
            };
        }
    }
}
