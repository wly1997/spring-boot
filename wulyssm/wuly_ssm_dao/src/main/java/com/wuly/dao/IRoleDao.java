package com.wuly.dao;

import com.wuly.domain.Permission;
import com.wuly.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IRoleDao {

    @Select("SELECT * FROM role where id in (select roleId from users_role where userid = #{userId})")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions", column = "id", javaType = List.class, many = @Many(select = "com.wuly.dao.IPermisssionDao.findByRoleId"))

    })
    List<Role> findRoleByUserId (String userId)throws Exception;
    @Select("SELECT * FROM role")
    List<Role> findAll()throws Exception;

    @Insert("INSERT INTO role VALUES( REPLACE(UUID(),'-',''),#{roleName},#{roleDesc});")
    void save(Role role);

    @Select("Select * from role where id =#{id}")
    Role findRoleById(String id);

    @Select("select * from permission where id not in (select permissionId from role_permission where roleId =#{id})")
    List<Permission> findOtherPermission(String id);

    @Insert("INSERT INTO `role_permission` VALUES(#{pid},#{rid})")
    void addPermissionToRole(@Param("rid") String id, @Param("pid") String pid);
}
