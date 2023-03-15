package com.example.banksystem.dto.converter;

import com.example.banksystem.dto.response.RoleDto;
import com.example.banksystem.model.Role;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RoleConverter {
    public RoleDto convertToDto(Role role){
        return new RoleDto(
                role.getRoleName()
        );
    }
    public List<RoleDto> convertToDtoList(List<Role> roles){
        return roles.stream().map(from -> convertToDto(from)).collect(Collectors.toList());
    }

    public Role convertToEntity(RoleDto roleDto){
        return new Role(
                roleDto.getRoleName()
        );
    }
}
