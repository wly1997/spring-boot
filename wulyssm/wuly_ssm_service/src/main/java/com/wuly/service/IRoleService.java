package com.wuly.service;

import com.wuly.domain.Permission;
import com.wuly.domain.Role;

import java.util.List;

public interface IRoleService {
    List<Role> findAll() throws Exception;

    void save(Role role);


    Role findRoleById(String id);

    List<Permission> findOtherPermission(String id);

    void addPermissionToRole(String id, String[] pids);
}
