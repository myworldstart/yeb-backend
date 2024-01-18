package com.example.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.server.config.security.JwTokenUtil;
import com.example.server.mapper.AdminMapper;
import com.example.server.pojo.Admin;
import com.example.server.pojo.RespBean;
import com.example.server.service.IAdminService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import sun.security.util.Password;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhoubin
 * @since 2024-01-10
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {

    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwTokenUtil jwTokenUtil;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Override
    public RespBean login(String username, String password, HttpServletRequest request) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        if(null == userDetails || !passwordEncoder.matches(password, userDetails.getPassword())){
            return RespBean.error("用户名或密码不正确");
        }
        if(!userDetails.isEnabled()){
            return RespBean.error("账号被禁用，请联系管理员");
        }

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

        String token = jwTokenUtil.generateToken(userDetails);
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return RespBean.success("登陆成功", tokenMap);
    }

    @Override
    public Admin getAdminByUserName(String username) {
        return adminMapper.selectOne(new QueryWrapper<Admin>().eq("username", username).eq("enabled", true));
    }
}
