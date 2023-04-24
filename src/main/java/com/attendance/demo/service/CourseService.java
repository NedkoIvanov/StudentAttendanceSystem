package com.attendance.demo.service;

import com.attendance.demo.model.view.CourseInfoViewModel;

import java.util.List;

public interface CourseService {

    void seedCourses();

    List<CourseInfoViewModel> getCourseInfoForCurrentTeacher(String teacherMail);
}
