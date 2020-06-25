package com.wuly.service.impl;

import com.wuly.dao.ISysLogDao;
import com.wuly.domain.SysLog;
import com.wuly.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional

public class SysLogService implements ISysLogService {
    @Autowired
    private ISysLogDao sysLogDao;

    @Override
    public List<SysLog> findAll() {
        return sysLogDao.findAll();
    }

    @Override
    public void save(SysLog sysLog) {
        sysLogDao.save(sysLog);

    }
}
