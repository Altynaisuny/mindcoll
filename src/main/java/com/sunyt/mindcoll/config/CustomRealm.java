package com.sunyt.mindcoll.config;

import com.sunyt.mindcoll.dao.repository.UserRepository;
import com.sunyt.mindcoll.model.ResourceDto;
import com.sunyt.mindcoll.model.Role;
import com.sunyt.mindcoll.model.User;
import com.sunyt.mindcoll.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * customRealm是一个自定义认证类，继承AuthorizingRealm，负责用户的认证和权限管理。
 * @author altynai
 */
public class CustomRealm extends AuthorizingRealm {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;
    /**
     * 验证当前登录的Subject
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        List<User> userList = userRepository.findByUsername(username);
        if (CollectionUtils.isEmpty(userList)){
            throw new UnknownAccountException("用户不存在");
        }
        User user = userList.get(0);
        // principal credentials realmName
        return new SimpleAuthenticationInfo(user, user.getPassword(), "CustomRealm");
    }

    /**
     * 用于获取登录成功后的角色、权限等信息
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        Object principal= principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        //首先确定角色
        List<Role> roles =  userService.findRoleById(principal.toString());
        Set<String>  roleSet = new HashSet<>();
        roles.forEach(role->{
            roleSet.add(role.getRoleName());
        });
        authorizationInfo.setRoles(roleSet);
        //然后确定权限
        List<ResourceDto> resourceDtos = userService.findPermissionByRoleName(roleSet);
        //permission
        Set<String> permissions = new HashSet<>();
        resourceDtos.forEach(resource -> {
            permissions.add(resource.getResourceUrl());
        });
        authorizationInfo.setStringPermissions(permissions);
        //登录成功后会创建一个subject subject role create role
        return authorizationInfo;
    }

}
