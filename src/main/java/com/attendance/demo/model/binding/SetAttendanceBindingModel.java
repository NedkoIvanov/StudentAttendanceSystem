package com.attendance.demo.model.binding;

import com.attendance.demo.model.entity.Enums.GradeEnum;

import javax.validation.constraints.NotNull;
public class SetAttendanceBindingModel {

    @NotNull
    private GradeEnum grade;

    public SetAttendanceBindingModel(){}

    public SetAttendanceBindingModel(GradeEnum grade){
        this.grade = grade;
    }

    public GradeEnum getGrade() {
        return grade;
    }

    public void setGrade(GradeEnum grade) {
        this.grade = grade;
    }
}
