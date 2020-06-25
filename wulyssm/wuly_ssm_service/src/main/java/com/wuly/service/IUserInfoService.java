package com.wuly.service;

import com.wuly.domain.Role;
import com.wuly.domain.UserInfo;

import java.util.List;

public interface IUserInfoService {

    List<UserInfo> findAll()throws Exception;

    void save(UserInfo userInfo)throws Exception;

    UserInfo findById(String id);

    List<Role> findOtherRole(String id);

    void addRoleToUser(String userId, String[] roleId);
}
