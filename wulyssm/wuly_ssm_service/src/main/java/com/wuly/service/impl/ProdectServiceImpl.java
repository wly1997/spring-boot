package com.wuly.service.impl;

import com.wuly.dao.IProductDao;
import com.wuly.domain.Product;
import com.wuly.service.IProdectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ProdectServiceImpl implements IProdectService {

    @Autowired
    private IProductDao productDao;

    @Override
    public List<Product> findAll() throws Exception {
        return productDao.findAll();

    }

    @Override
    public void save(Product product) throws Exception {
       productDao.save(product);
    }
}
