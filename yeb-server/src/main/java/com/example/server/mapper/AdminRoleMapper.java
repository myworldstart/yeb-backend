package com.example.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.server.pojo.AdminRole;
import com.example.server.pojo.RespBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhoubin
 * @since 2024-01-10
 */
@Mapper
public interface AdminRoleMapper extends BaseMapper<AdminRole> {

    Integer addAdminRole(@Param("adminId") Integer adminId, @Param("rids") Integer[] rids);
}
