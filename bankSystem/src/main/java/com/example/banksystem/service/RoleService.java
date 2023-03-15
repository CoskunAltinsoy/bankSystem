package com.example.banksystem.service;

import com.example.banksystem.dto.request.CreateRoleRequest;
import com.example.banksystem.dto.response.RoleDto;

public interface RoleService {
    public void createRole(CreateRoleRequest createRoleRequest);
    public RoleDto getRoleById(Long id);
}
