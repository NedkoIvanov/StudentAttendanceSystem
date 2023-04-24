package com.attendance.demo.model.entity;

import javax.persistence.*;

import java.util.List;
@Entity
public class CourseEntity extends Base{


    private String courseName;
    @Lob
    private String info;

    @OneToMany(mappedBy = "course")
    private List<SessionEntity> sessions;

//    @OneToMany(mappedBy = "studentCourse")
    @OneToMany
    private List<UserEntity> students;

    @ManyToMany
    private List<UserEntity> teachers;

    public CourseEntity(){}

    public CourseEntity(String courseName, String info, List<SessionEntity> sessions, List<UserEntity> students, List<UserEntity> teachers) {
        this.courseName = courseName;
        this.info = info;
        this.sessions = sessions;
        this.students = students;
        this.teachers = teachers;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public List<SessionEntity> getSessions() {
        return sessions;
    }

    public void setSessions(List<SessionEntity> sessions) {
        this.sessions = sessions;
    }

    public List<UserEntity> getStudents() {
        return students;
    }

    public void setStudents(List<UserEntity> students) {
        this.students = students;
    }

    public List<UserEntity> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<UserEntity> teachers) {
        this.teachers = teachers;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
