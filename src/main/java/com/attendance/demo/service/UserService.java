package com.attendance.demo.service;

import com.attendance.demo.model.binding.RegisterBindingModel;
import com.attendance.demo.model.binding.SetAttendanceBindingModel;
import com.attendance.demo.model.entity.UserEntity;

public interface UserService {

    UserEntity findByEmail(String email);

    void registerUser(RegisterBindingModel registerBindingModel);

    void seedStudents();

    void seedTeachers();

    void setAttendance(SetAttendanceBindingModel setAttendanceBindingModel,Long id);
}
