package com.sunyt.mindcoll.controller;

import com.sunyt.mindcoll.dao.repository.UserRepository;
import com.sunyt.mindcoll.model.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author altynai
 */
@RestController
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/user/userList", method = RequestMethod.GET)
    public Model getUserListByNameAndPass(@PathVariable("username") String username, Model model){
        List<User> userList = userRepository.findByUsername(username);
        if (userList != null){
            model.addAttribute("userList", userList);
            userList.forEach(str->{
                System.out.println(str.getUsername());
            });
        }
        return model;
    }
    @RequestMapping(value = "/test/test", method = RequestMethod.POST)
    public User getUserListByNameAndPass1(@RequestBody User user){
        Subject subject = SecurityUtils.getSubject();
        System.out.println(subject.getPrincipal());
        return user;
    }
}
