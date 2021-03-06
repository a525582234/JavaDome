package com.wty.report.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wty.report.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
@DS("mysql")
public interface UserMapper extends BaseMapper<User> {
}
