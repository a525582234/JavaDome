package com.wty.common.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Classname MybatisPlusConfig
 * @Description MybatisPlus配置
 * @Date 2021/12/3 11:53
 * @@author wty
 */
@Configuration
public class MybatisPlusConfig {
    /**
     * 分页拦截器
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        //设置数据库类型
        paginationInterceptor.setDbType(DbType.MYSQL);
        return paginationInterceptor;
    }

}
