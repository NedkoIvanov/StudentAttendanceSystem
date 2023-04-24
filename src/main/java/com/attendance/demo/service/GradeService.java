package com.attendance.demo.service;

import com.attendance.demo.model.binding.EditGradeValueBindingModel;
import com.attendance.demo.model.view.GradeToEditViewModel;

import java.util.List;

public interface GradeService {
    void seedGrades();

    List<GradeToEditViewModel> findAllToEdit();

    void changeGradeValue(Long id, EditGradeValueBindingModel editGradeValueBindingModel);
}
