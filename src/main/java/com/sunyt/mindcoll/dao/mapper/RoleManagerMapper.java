package com.sunyt.mindcoll.dao.mapper;

import com.sunyt.mindcoll.model.ResourceDto;
import com.sunyt.mindcoll.model.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Mapper
public interface RoleManagerMapper {
    /**
     * 获取用户所有role
     * @param map
     * @return
     */
    public List<Role> findRoleById(Map map);

    /**
     * 获取role 对应的 resource
     * @param rolesList
     * @return
     */
    public List<ResourceDto> findResourceByRoleName(Set rolesList);
}
