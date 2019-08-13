package com.sunyt.mindcoll.controller;

import com.sunyt.mindcoll.dao.repository.UserRepository;
import com.sunyt.mindcoll.model.User;
import com.sunyt.mindcoll.service.ThreadTest;
import com.sunyt.mindcoll.service.ThreadTestUtils;
import com.sunyt.mindcoll.util.GlobalResponse;
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

    @Autowired
    ThreadTestUtils threadTestUtils;

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
    public String getUserListByNameAndPass1(@RequestBody User user){
        try {
            Subject subject = SecurityUtils.getSubject();
            return "success";
        } catch (Exception e){
            e.printStackTrace();
        }
        return "error";
    }

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public String getUserListEe(@RequestBody User user){
        threadTestUtils.getExecutorService().execute(new ThreadTest(""));
        return "error";
    }
}
