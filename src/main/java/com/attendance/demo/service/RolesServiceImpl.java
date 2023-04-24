package com.attendance.demo.service;

import com.attendance.demo.model.entity.Enums.RoleEnum;
import com.attendance.demo.model.entity.RoleEntity;
import com.attendance.demo.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RolesServiceImpl implements RoleService{
    private final RoleRepository roleRepository;

    public RolesServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void seedRoles() {
        long count = this.roleRepository.count();
        if(count!=0){
            return;
        }
        List<RoleEntity> roles = new ArrayList<>();
        roles.add(new RoleEntity(RoleEnum.ADMIN));
        roles.add(new RoleEntity(RoleEnum.TEACHER));
        roles.add(new RoleEntity(RoleEnum.STUDENT));
        this.roleRepository.saveAll(roles);
    }
}
