package com.example.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.server.pojo.Admin;
import com.example.server.pojo.Menu;
import com.example.server.pojo.RespBean;
import com.example.server.pojo.Role;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


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
     *
     * @param username
     * @param password
     * @param code
     * @param request
     * @return
     */
    RespBean login(String username, String password, String code, HttpServletRequest request);

    Admin getAdminByUserName(String username);

    List<Role> getRoles(Integer adminId);

}
