package com.wuly.dao;

import com.wuly.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ITravellerDao {
    @Select("select * from traveller where id in (select id from order_traveller where orderId =#{id})")
    List<Traveller> findByOrdersId (String id)throws Exception;
}
