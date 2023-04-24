package com.attendance.demo.model.view;

import com.attendance.demo.model.entity.Enums.GradeEnum;

import java.util.List;

public class StudentTableViewModel {

    private String sessionName;

    private Long studentId;
    private String firstName;

    private String familyName;

    private String email;

    private List<GradeEnum> grades;

    public StudentTableViewModel(){}

    public StudentTableViewModel(String sessionName, Long studentId, String firstName,
                                 String familyName, String email, List<GradeEnum> grades) {
        this.sessionName = sessionName;
        this.studentId = studentId;
        this.firstName = firstName;
        this.familyName = familyName;
        this.email = email;
        this.grades = grades;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getSessionName() {
        return sessionName;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    public List<GradeEnum> getGrades() {
        return grades;
    }

    public void setGrades(List<GradeEnum> grades) {
        this.grades = grades;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }
}
