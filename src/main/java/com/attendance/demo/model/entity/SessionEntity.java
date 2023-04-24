package com.attendance.demo.model.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class SessionEntity extends Base{

    private String name;
    private String info;

    private String time;
    private String day;
    private Boolean active;

    @ManyToOne
    private UserEntity teacher;

    @ManyToOne
    private CourseEntity course;

    public SessionEntity(){}

    public SessionEntity(String name, String info, String time, String day, Boolean active, UserEntity teachers, CourseEntity course) {
        this.name = name;
        this.info = info;
        this.time = time;
        this.day = day;
        this.active = active;
        this.teacher = teachers;

        this.course = course;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public CourseEntity getCourse() {
        return course;
    }

    public void setCourse(CourseEntity course) {
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public UserEntity getTeacher() {
        return teacher;
    }

    public void setTeacher(UserEntity teacher) {
        this.teacher = teacher;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}
