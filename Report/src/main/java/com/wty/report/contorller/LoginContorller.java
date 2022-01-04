package com.wty.report.contorller;
import com.wty.report.config.JwtConfig;
import com.wty.common.config.R;
import com.wty.report.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * 登录前端控制器
 * @author wty
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class LoginContorller {

    final
    JwtConfig jwtConfig;

    public LoginContorller(JwtConfig jwtConfig) {
        this.jwtConfig = jwtConfig;
    }

    @GetMapping("/info")
    public R<HashMap> getInfo() {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("roles", "admin");
        map.put("introduction", "I am a superadministrator");
        map.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        map.put("name", "Super Admin");
        return R.success(map);
    }
    @PostMapping("/login")
    public R<String> login(@RequestBody User user) {
//        String token = jwtConfig.getHeader() + jwtConfig.getSecret() + jwtConfig.getPrefix();
        String token = "1";
        log.info("user  " + user.toString());
        log.info("token " + token);
        return R.success(token);
    }
    @PostMapping("/logout")
    public R<String> logout() {
        String token = "1";
        log.info("token " + token);
        return R.success(token);
    }
}
