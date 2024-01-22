package com.example.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.server.pojo.MenuRole;
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
public interface MenuRoleMapper extends BaseMapper<MenuRole> {

    Integer insertRecord(@Param("rid") Integer rid, @Param("mids") Integer[] mids);
}
