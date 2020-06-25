package com.wuly.service.impl;


import com.wuly.dao.IPermisssionDao;
import com.wuly.domain.Permission;
import com.wuly.service.IPermissionService;
import com.wuly.service.IProdectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PermissionServiceImpl implements IPermissionService {
    @Autowired
    private IPermisssionDao permisssionDao;
    @Override
    public List<Permission> findAll()throws Exception{
        List<Permission> permissions = permisssionDao.findAll();

        return permissions;
    }

    @Override
    public void save(Permission permission) throws Exception {
        permisssionDao.save(permission);
    }
}
