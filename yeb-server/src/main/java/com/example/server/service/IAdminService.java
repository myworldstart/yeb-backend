package com.example.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.server.pojo.Admin;
import com.example.server.pojo.RespBean;

import javax.servlet.http.HttpServletRequest;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhoubin
 * @since 2024-01-10
 */
public interface IAdminService extends IService<Admin> {

    /**
     * 登录之后实现方法
     * @param username
     * @param password
     * @param request
     * @return
     */
    RespBean login(String username, String password, HttpServletRequest request);

    Admin getAdminByUserName(String username);
}
