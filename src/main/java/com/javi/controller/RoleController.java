package com.javi.controller;

import com.javi.entity.Role;
import com.javi.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/javi/role")
public class RoleController extends AbstractController<Role, Long> {

    @Autowired
    private RoleService roleService;

    public RoleController() {
        super.setService(roleService);
    }
}
