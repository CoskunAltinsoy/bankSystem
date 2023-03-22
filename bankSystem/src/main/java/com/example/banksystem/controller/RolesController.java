package com.example.banksystem.controller;

import com.example.banksystem.dto.request.CreateRoleRequest;
import com.example.banksystem.dto.response.RoleDto;
import com.example.banksystem.service.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/roles")
public class RolesController {
    private final RoleService roleService;
    public RolesController(RoleService roleService) {
        this.roleService = roleService;
    }
    @PostMapping
    public ResponseEntity<Void> createRole(CreateRoleRequest createRoleRequest){
        roleService.createRole(createRoleRequest);
        return (ResponseEntity<Void>) ResponseEntity.ok();
    }
    @GetMapping("{id}")
    public ResponseEntity<RoleDto> getByRoleId(@PathVariable("id") Long id){
        return ResponseEntity.ok(roleService.getRoleById(id));
    }
}
