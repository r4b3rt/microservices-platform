package org.zlt.controller;

import com.central.common.annotation.LoginUser;
import com.central.common.model.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zlt
 * @date 2022/6/25
 * <p>
 * Blog: https://zlt2000.gitee.io
 * Github: https://github.com/zlt2000
 */
@Slf4j
@RestController
public class TestController {
    @GetMapping("/test/auth")
    public String auth(@LoginUser SysUser user) {
        return "auth：" + user.getUsername();
    }

    @GetMapping("/test/notAuth")
    public String notAuth() {
        return "notAuth：ok";
    }
}
