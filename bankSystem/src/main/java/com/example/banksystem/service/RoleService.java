package com.example.banksystem.service;

import com.example.banksystem.dto.request.CreateRoleRequest;
import com.example.banksystem.dto.response.RoleDto;
import com.example.banksystem.model.Role;

public interface RoleService {
    public void createRole(CreateRoleRequest createRoleRequest);
    public RoleDto getRoleById(Long id);

}
