package com.attendance.demo.model.entity;

import com.attendance.demo.model.entity.Enums.RoleEnum;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class RoleEntity extends Base {

    @Enumerated(EnumType.STRING)
    private RoleEnum roles;

    public RoleEntity() {
    }

    public RoleEntity(RoleEnum roles) {
        this.roles = roles;
    }

    public RoleEnum getRoles() {
        return roles;
    }

    public void setRoles(RoleEnum roles) {
        this.roles = roles;
    }

}
