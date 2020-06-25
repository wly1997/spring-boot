package com.wuly.service.impl;

import com.wuly.dao.IRoleDao;
import com.wuly.domain.Permission;
import com.wuly.domain.Role;
import com.wuly.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private IRoleDao roleDao;

    @Override
    public void save(Role role) {
        roleDao.save(role);
    }

    @Override
    public Role findRoleById(String id) {
        return roleDao.findRoleById(id);
    }

    @Override
    public List<Permission> findOtherPermission(String id) {
        return roleDao.findOtherPermission(id);
    }

    @Override
    public void addPermissionToRole(String id, String[] pids) {
        for (String pid : pids) {
            roleDao.addPermissionToRole(id,pid);
        }

    }

    @Override
    public List<Role> findAll() throws Exception {
        List<Role> roles = roleDao.findAll();
        return roles;
    }
}
