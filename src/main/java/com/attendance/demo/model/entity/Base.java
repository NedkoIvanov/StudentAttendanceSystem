package com.attendance.demo.model.entity;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Base {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Base(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
