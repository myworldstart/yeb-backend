package com.example.server.controller;

import com.example.server.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/system/basic/permiss")
public class PermissController {

    @Autowired
    private IRoleService roleService;

}
