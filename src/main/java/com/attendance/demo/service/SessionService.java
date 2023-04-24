package com.attendance.demo.service;

import com.attendance.demo.model.view.StudentTableViewModel;

import java.util.List;

public interface SessionService {

    void seedSessions();

    void seedSessionCourse();
    List<StudentTableViewModel> currentSessionStudents(Long id);

}
