package com.wuly.dao;

import com.wuly.domain.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ISysLogDao {
    @Select("SELECT * FROM syslog")
    List<SysLog> findAll();

    @Insert("insert into syslog values(REPLACE(UUID(),'-',''),#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
    void save(SysLog sysLog);
}
