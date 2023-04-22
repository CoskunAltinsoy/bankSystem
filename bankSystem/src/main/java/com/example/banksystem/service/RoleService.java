package com.example.banksystem.service;

import com.example.banksystem.dto.request.create.CreateRoleRequest;
import com.example.banksystem.dto.response.RoleResponse;

public interface RoleService {
    public void createRole(CreateRoleRequest createRoleRequest);
    public RoleResponse getRoleById(Long id);
}
