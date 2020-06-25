package com.wuly.service;

import com.wuly.domain.Orders;

import java.util.List;

public interface IOrdersService {
    
    List<Orders> findAll(int page, int size) throws Exception;

    Orders findById(String id);
}
