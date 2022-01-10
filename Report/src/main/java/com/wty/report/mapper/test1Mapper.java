package com.wty.report.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wty.report.entity.User;
import com.wty.report.entity.test1;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
@DS("doris")
public interface test1Mapper extends BaseMapper<test1> {
    test1 test1();
}
