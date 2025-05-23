package com.central.common.feign;

import com.central.common.constant.ServiceNameConstants;
import com.central.common.feign.fallback.UserServiceFallbackFactory;
import com.central.common.model.Result;
import com.central.common.model.SysRole;
import com.central.common.model.SysUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zlt
 */
@FeignClient(name = ServiceNameConstants.USER_SERVICE, fallbackFactory = UserServiceFallbackFactory.class, dismiss404 = true)
public interface UserService {
    /**
     * feign rpc访问远程/users/{username}接口
     * 查询用户实体对象SysUser
     *
     * @param username
     * @return
     */
    @GetMapping(value = "/users/name/{username}")
    SysUser selectByUsername(@PathVariable("username") String username);

    /**
     * feign rpc访问远程/users-anon/login接口
     *
     * @param username
     * @return
     */
    @GetMapping(value = "/users-anon/login", params = "username")
    SysUser findByUsername(@RequestParam("username") String username);

    /**
     * 通过手机号查询用户、角色信息
     *
     * @param mobile 手机号
     */
    @GetMapping(value = "/users-anon/mobile", params = "mobile")
    SysUser findByMobile(@RequestParam("mobile") String mobile);

    /**
     * 根据OpenId查询用户信息
     *
     * @param openId openId
     */
    @GetMapping(value = "/users-anon/openId", params = "openId")
    SysUser findByOpenId(@RequestParam("openId") String openId);


    /**
     * 获取带角色的用户信息
     * @param username
     * @return
     */
    @GetMapping(value = "/users/roleUser/{username}")
    SysUser selectRoleUser(@PathVariable("username") String username);

    /**
     * 获取用户的角色
     *
     * @param
     * @return
     */
    @GetMapping("/users/{id}/roles")
    List<SysRole> findRolesByUserId(@PathVariable("id") Long id);

    /**
     * 保存用户
     */
    @PostMapping("/users/saveOrUpdate")
    Result saveOrUpdate(@RequestBody SysUser sysUser);
}
