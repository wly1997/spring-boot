package com.wuly.dao;

import com.wuly.domain.Member;
import com.wuly.domain.Orders;
import com.wuly.domain.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IOrdersDao {
    @Select("SELECT * FROM orders")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product",column = "productId",javaType = Product.class,one = @One(select = "com.wuly.dao.IProductDao.findById"))
    })
    List<Orders> findAll() throws Exception ;


    @Select("SELECT * FROM orders where id = #{id}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product",column = "productId",javaType = Product.class,one = @One(select = "com.wuly.dao.IProductDao.findById")),
            @Result(property ="member" ,column = "memberId",javaType = Member.class,one = @One(select = "com.wuly.dao.IMemberDao.findById")),
            @Result(property ="travellers",column = "id",javaType = List.class,many = @Many( select = "com.wuly.dao.ITravellerDao.findByOrdersId"))

    })
    Orders findById(String id);
}
