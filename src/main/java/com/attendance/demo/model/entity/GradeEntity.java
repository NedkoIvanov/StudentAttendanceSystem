package com.attendance.demo.model.entity;

import com.attendance.demo.model.entity.Enums.GradeEnum;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class GradeEntity extends Base{

    @Enumerated(EnumType.STRING)
    private GradeEnum grades;

    private int mark;


    public GradeEntity(){
    }
    public GradeEntity(GradeEnum grades, int mark) {
        this.grades = grades;
        this.mark = mark;
    }
    public GradeEntity(GradeEnum grades){
        this.grades = grades;
    }

    public GradeEnum getGrades() {
        return grades;
    }

    public void setGrades(GradeEnum grades) {
        this.grades = grades;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }
}
