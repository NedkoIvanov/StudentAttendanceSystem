package com.attendance.demo.model.entity;

import com.attendance.demo.model.entity.Enums.GradeEnum;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity

public class UserEntity extends Base{

    private String email;

    private String password;

    private String firstName;

    private String familyName;

    private String egn;

    private String phoneNumber;
    @ManyToMany
    private List<RoleEntity> roles;

    @ManyToMany
    private List<GradeEntity> grades;

    @ManyToMany(mappedBy = "teachers")
    private List<CourseEntity> teacherCourse;

//    @ManyToOne
//    private CourseEntity studentCourse;

    public UserEntity(){}

    public UserEntity(String email, String password, String firstName, String familyName, String egn, String phoneNumber,
                      List<RoleEntity> roles, List<GradeEntity> grades,
                      List<CourseEntity> teacherCourse) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.familyName = familyName;
        this.egn = egn;
        this.phoneNumber = phoneNumber;
        this.roles = roles;
        this.grades = grades;
        this.teacherCourse = teacherCourse;
       // this.studentCourse = studentCourse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getEgn() {
        return egn;
    }

    public void setEgn(String egn) {
        this.egn = egn;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleEntity> roles) {
        this.roles = roles;
    }

    public List<GradeEntity> getGrades() {
        return grades;
    }

    public void setGrades(List<GradeEntity> grades) {
        this.grades = grades;
    }

    public List<CourseEntity> getTeacherCourse() {
        return teacherCourse;
    }

    public void setTeacherCourse(List<CourseEntity> teacherCourse) {
        this.teacherCourse = teacherCourse;
    }

//    public CourseEntity getStudentCourse() {
//        return studentCourse;
//    }
//
//    public void setStudentCourse(CourseEntity studentCourse) {
//        this.studentCourse = studentCourse;
//    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<GradeEnum> getGradeVariations(){

        List<GradeEnum> gradeList = new ArrayList<>();

        if(this.grades.size()==0){
            return null;
        }else{
            for(int i=0;i<this.grades.size();i++){
                gradeList.add(this.grades.get(i).getGrades());
            }
            return gradeList;
        }

    }

    public List<GradeEntity> addGradesToStudent(GradeEntity grade){
        if(grade != null) {
            this.grades.add(grade);
        }
        return this.grades;
    }

}
