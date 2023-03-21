package com.example.banksystem.service.implementation;

import com.example.banksystem.dto.converter.RoleConverter;
import com.example.banksystem.dto.request.CreateRoleRequest;
import com.example.banksystem.dto.response.RoleDto;
import com.example.banksystem.model.Role;
import com.example.banksystem.repository.RoleRepository;
import com.example.banksystem.service.RoleService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    private final RoleConverter roleConverter;
    public RoleServiceImpl(RoleRepository roleRepository, RoleConverter roleConverter) {
        this.roleRepository = roleRepository;
        this.roleConverter = roleConverter;
    }

    @Override
    public void createRole(CreateRoleRequest createRoleRequest) {
        Role role = new Role(
                createRoleRequest.getRoleType()
        );
        role.setCreatedDate(LocalDate.now());
        role.setDeleted(false);
        roleRepository.save(role);
    }

    @Override
    public RoleDto getRoleById(Long id) {
        Role role = roleRepository.findById(id).orElseThrow();
        if (role.isDeleted()){
            return null;
        }
        return roleConverter.convertToDto(role);
    }


}
