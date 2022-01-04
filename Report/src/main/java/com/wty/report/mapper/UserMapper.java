package com.wty.report.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wty.report.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
