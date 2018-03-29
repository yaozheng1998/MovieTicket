package com.yz; /**
 * @Author YZ
 * @Date 2018/3/29
 */

import feign.Contract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Feign的配置类
 */
@Configuration
public class FeignConfiguration {
    /**
     * 将契约改成Feign原生的默认契约，就可以使用Feign自带的注解了
     * @return 默认的feign契约
     */
    @Bean
    public Contract feignContract(){
        return new feign.Contract.Default();
    }
}
