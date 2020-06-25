package com.wuly.dao;

import com.wuly.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IProductDao {
    @Select("select * from product where id =#{id}")
    public  Product findById(Integer id) throws Exception;


    @Select("SELECT * FROM product")
    List<Product> findAll() throws Exception;



    @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product);
}
