package com.wuly.dao;

import com.wuly.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IPermisssionDao {
    @Select("select * from permission where id in(select permissionId from role_permission where roleId =#{id})")
    List<Permission> findByRoleId();

    @Select("select * from permission")
    List<Permission> findAll();


    @Insert("INSERT INTO `permission` VALUES( REPLACE(UUID(),'-',''),#{permissionName},#{url})")
    void save(Permission permission);
}
