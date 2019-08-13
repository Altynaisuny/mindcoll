package com.sunyt.mindcoll.controller;

import com.sunyt.mindcoll.dao.repository.UserRepository;
import com.sunyt.mindcoll.model.User;
import com.sunyt.mindcoll.util.GlobalResponse;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    /**
     * 前后端不分离
     *
     * @return
     */
    @RequestMapping("/notSlime/login")
    public GlobalResponse login(@RequestParam String username, @RequestParam String password) {
        Subject subject = SecurityUtils.getSubject();
        GlobalResponse response = new GlobalResponse();
        if (!subject.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            try {
                subject.login(token);
            } catch (UnknownAccountException unKnowException) {
                System.out.println("UnknownAccountException" + token.getPrincipal() + "user not");
            } catch (IncorrectCredentialsException inException) {
                System.out.println("IncorrectCredentialsException" + token.getPrincipal() + "password is error");
            } catch (LockedAccountException lockException) {
                System.out.println("LockedAccountException" + lockException.getMessage() + "user :" + token.getPrincipal() + " is lock");
            } catch (AuthenticationException e) {
                System.out.println("error not ");
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * JSON类型的请求，通过后缀 .json 前端进行拦截。
     * @param loginUser
     * @param model
     * @return
     */
    @RequestMapping(value = "/guest/login", method = RequestMethod.POST)
    public GlobalResponse login(@RequestBody User loginUser, Model model) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken userPassToken = null;
        if (!subject.isAuthenticated()) {
            userPassToken = new UsernamePasswordToken();
            ByteSource salt = ByteSource.Util.bytes(loginUser.getUsername());
            SimpleHash simpleHash = new SimpleHash("MD5", loginUser.getPassword(), salt, 1024);
            userPassToken.setUsername(loginUser.getUsername());
            userPassToken.setPassword(simpleHash.toString().toCharArray());
        }
        try {
            subject.login(userPassToken);
        }catch (Exception e){
            return GlobalResponse.fail(e.getMessage());
        }
        return GlobalResponse.success(subject + "login successfully");
    }

    /**
     * 退出登录
     */
    //@RequiresRoles("ROLE_SUPER")
    @RequestMapping(value="/logout.json",method= RequestMethod.GET)
    public String logout() {
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        return "";
    }

    //@RequiresRoles("ROLE_USER")
    @RequestMapping(value = "/guest/checkToken", method = RequestMethod.POST)
    public GlobalResponse subjectConfirm(){
        Subject subject = SecurityUtils.getSubject();
        return GlobalResponse.success(subject.getPrincipal());
    }

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public User getUserListByNameAndPass1(@RequestBody User user){

        return user;
    }

    @RequestMapping("/guest/test")
    public void getModelTest(HttpServletRequest request){
        Map<String, String[]> parameterMap = request.getParameterMap();
        String username = request.getParameter("username");
    }


}
