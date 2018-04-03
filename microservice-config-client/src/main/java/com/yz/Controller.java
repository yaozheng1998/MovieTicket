package com.yz;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author YZ
 * @Date 2018/4/3
 */
@RestController
public class Controller {
    @Value("${profile}")
    private String profile;
    @GetMapping("/profile")
    public String hello(){
        return this.profile;
    }
}
