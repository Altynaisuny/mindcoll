package com.sunyt.mindcoll.service;

import com.sunyt.mindcoll.dao.mapper.RoleManagerMapper;
import com.sunyt.mindcoll.model.ResourceDto;
import com.sunyt.mindcoll.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.*;

@Service
public class UserService {
    @Autowired
    private RoleManagerMapper roleManagerMapper;

    public List<Role> findRoleById(String uid){
        if (StringUtils.isEmpty(uid)){
            return null;
        }
        Map paramMap = new HashMap();
        paramMap.put("id", uid);
        return roleManagerMapper.findRoleById(paramMap);
    }

    public List<ResourceDto> findPermissionByRoleName(Set<String> rolesList){
        if (CollectionUtils.isEmpty(rolesList)){
            return null;
        }
        return roleManagerMapper.findResourceByRoleName(rolesList);
    }
}
