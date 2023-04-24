package com.attendance.demo.model.view;

import com.attendance.demo.model.entity.Enums.GradeEnum;

public class GradeToEditViewModel {

    private Long id;

    private String grades;

    private int mark;

    public GradeToEditViewModel(){}

    public GradeToEditViewModel(Long id, String grades, int mark) {
        this.id = id;
        this.grades = grades;
        this.mark = mark;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGrades() {
        return grades;
    }

    public void setGrades(String grades) {
        this.grades = grades;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }
}
