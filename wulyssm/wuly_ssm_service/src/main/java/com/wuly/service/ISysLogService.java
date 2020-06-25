package com.wuly.service;

import com.wuly.domain.SysLog;

import java.util.List;

public interface ISysLogService {
    List<SysLog> findAll();
    void save(SysLog sysLog);
}
