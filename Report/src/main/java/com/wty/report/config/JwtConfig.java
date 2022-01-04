package com.wty.report.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Classname JwtConfig
 * @Description jwt配置
 * @Date 2021/12/9 17:07
 * @@author wty
 */
@Component
public class JwtConfig {

    /**
     * 过期时间
     */
    @Value("${spring.jwt.time}")
    private long time;
    /**
     * JWT密码
     */
    @Value("${spring.jwt.secret}")
    private String secret;
    /**
     * Token前缀
     */
    @Value("${spring.jwt.prefix}")
    private String prefix;
    /**
     * 存放Token的Header Key
     */
    @Value("${spring.jwt.header}")
    private String header;

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }
}
