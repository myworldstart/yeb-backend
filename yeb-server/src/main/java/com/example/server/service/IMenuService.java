package com.example.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.server.pojo.Menu;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhoubin
 * @since 2024-01-10
 */
public interface IMenuService extends IService<Menu> {

    List<Menu> getMenusByAdminId();

    List<Menu> getMenusWithRole();
}
