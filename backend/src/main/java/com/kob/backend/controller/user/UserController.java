package com.kob.backend.controller.user;

import com.kob.backend.mapper.UserMapper;
import com.kob.backend.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserMapper userMapper;
    @RequestMapping("/user/all/")
    public List<User> getAll(){
        return userMapper.selectList(null);
    }

    @GetMapping("/user/{userId}/")
    public User getuser(@PathVariable int userId){
        return userMapper.selectById(userId);
    }
    //这里可以看Mybatis-Plus官网学习一些api
    @GetMapping("/user/add/{userId}/{username}/{password}/")
    public String addUser(
        @PathVariable int userId,
        @PathVariable String username,
        @PathVariable String password){
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(password);
        User user = new User(userId,username,encodedPassword);
        userMapper.insert(user);
        return "Add User Successfully";
    }
    @GetMapping("/user/delete/{userId}/")
    public String deleteUser(@PathVariable int userId){
        userMapper.deleteById(userId);
        return "Delete user Successfully";
    }
//    @GetMapping("/user/updatepassword/{userId}/{username}/{password}/")
//    public String updateUser(
//            @PathVariable int userId,
//            @PathVariable String username,
//            @PathVariable String password){
//        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        String encodedPassword = passwordEncoder.encode(password);
//        User user2 = new User(userId,username,encodedPassword);
//        userMapper.updateById(user2);
//        return "Update User Successfully";
//    }

}
