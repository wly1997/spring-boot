package com.wuly.service;

import com.wuly.domain.Product;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IProdectService {
    List<Product> findAll() throws Exception;

    void save(Product product) throws Exception;
}
