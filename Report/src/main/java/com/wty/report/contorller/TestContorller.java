package com.wty.report.contorller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.collect.Maps;
import com.wty.common.config.R;
import com.wty.report.config.JwtConfig;
import com.wty.report.entity.User;
import com.wty.report.entity.test1;
import com.wty.report.mapper.UserMapper;
import com.wty.report.mapper.test1Mapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * test
 * @author wty
 */
@RestController
@RequestMapping("/test")
@Slf4j
public class TestContorller {

    final
    test1Mapper test1Mapper;
    final
    UserMapper userMapper;

    public TestContorller(test1Mapper test1Mapper, UserMapper userMapper) {
        this.test1Mapper = test1Mapper;
        this.userMapper = userMapper;
    }


    @GetMapping("/info")
    public R<HashMap> getInfo() {
        HashMap<Object, Object> map = Maps.newHashMap();
        List<test1> test1s = test1Mapper.selectList(Wrappers.lambdaQuery());
        map.put("1",test1s);
        return R.success(map);
    }
    @GetMapping("/info1")
    public R<HashMap> getInfo1() {
        HashMap<Object, Object> map = Maps.newHashMap();
        List<User> users = userMapper.selectList(Wrappers.lambdaQuery());
        map.put("1",users);
        return R.success(map);
    }


}
