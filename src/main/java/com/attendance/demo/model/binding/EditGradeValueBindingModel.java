package com.attendance.demo.model.binding;

import javax.validation.constraints.Min;

public class EditGradeValueBindingModel {

    @Min(value = 2)
    private int mark;

    public EditGradeValueBindingModel(){}
    public EditGradeValueBindingModel(int mark) {
        this.mark = mark;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }
}
