package com.ming.mapper;

import com.ming.bean.Role;
import org.apache.ibatis.annotations.Param;


import java.util.List;

/**
 *
 */
public interface RoleMapper {
    List<Role> roles();

    int addNewRole(@Param("role") String role, @Param("roleZh") String roleZh);

    int deleteRoleById(Long rid);
}
