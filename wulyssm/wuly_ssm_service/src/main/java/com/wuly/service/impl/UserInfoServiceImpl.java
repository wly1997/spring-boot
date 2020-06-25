package com.wuly.service.impl;

import com.wuly.dao.IUserInfoDao;
import com.wuly.domain.Role;
import com.wuly.domain.UserInfo;
import com.wuly.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserInfoServiceImpl implements IUserInfoService {
    @Autowired
    private IUserInfoDao userInfoDao;

    @Override
    public void addRoleToUser(String userId, String[] roleId) {
        for (int i = 0; i < roleId.length; i++) {
            userInfoDao.addRoleToUser(userId,roleId[i]);
        }

    }

    @Override
    public List<Role> findOtherRole(String id) {
        List<Role> roles=userInfoDao.findOtherRole(id);
        return roles;
    }

    @Override
    public UserInfo findById(String id) {
        UserInfo user =userInfoDao.findById(id);
        return user;
    }

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public List<UserInfo> findAll() throws Exception {
        List<UserInfo> users = userInfoDao.findAll();
        return users;
    }

    @Override
    public void save(UserInfo userInfo) throws Exception {
        //对密码进行加密
        userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
        userInfoDao.save(userInfo);

    }
}
