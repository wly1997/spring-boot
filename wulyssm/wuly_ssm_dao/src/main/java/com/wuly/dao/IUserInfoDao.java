package com.wuly.dao;

import com.wuly.domain.Role;
import com.wuly.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IUserInfoDao {
    @Select("select * from users")
    List<UserInfo> findAll();


    @Insert("INSERT INTO users VALUES( REPLACE(UUID(),'-',''),#{email},#{username},#{password},#{phoneNum},#{status});")
    void save(UserInfo userInfo);



    @Select("select * from users where id =#{id}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "email",column = "email"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "status",column = "status"),
            @Result(property = "roles",column = "id" ,javaType = List.class,many = @Many(select = "com.wuly.dao.IRoleDao.findRoleByUserId"))

    })
    UserInfo findById(String id);

    @Select("select * from role where Id not in (select roleId from users_role where userId =#{id})")
    List<Role> findOtherRole(String id);


    @Insert("INSERT INTO users_role VALUES(#{userId},#{roleId})")
    void addRoleToUser(@Param("userId") String userId, @Param("roleId") String roleId);
}
