package com.yz.Controller;

import com.yz.DAO.UserRepository;
import com.yz.Model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author YZ
 * @Date 2018/3/23
 */
@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public Users findById(@PathVariable Long id){
        Users findOne=this.userRepository.findOne(id);
        return findOne;
    }
}
