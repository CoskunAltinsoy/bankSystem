package com.example.banksystem.converter;

import com.example.banksystem.dto.request.create.CreateRoleRequest;
import com.example.banksystem.dto.response.RoleResponse;
import com.example.banksystem.model.Role;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RoleConverter {
    public RoleResponse convertToDto(Role role){
        RoleResponse roleResponse = new RoleResponse();

        roleResponse.setRoleName(role.getRoleName());

        return roleResponse;
    }
    public List<RoleResponse> convertToDtoList(List<Role> roles){
        return roles.stream().map(from -> convertToDto(from)).collect(Collectors.toList());
    }

    public Role convertToEntity(CreateRoleRequest createRoleRequest){
        Role role = new Role();

        role.setRoleName(createRoleRequest.getRoleName());

        return role;
    }
}
