package com.attendance.demo.model.view;

import com.attendance.demo.model.entity.SessionEntity;

public class CourseInfoViewModel {

    private String courseName;

    private String info;

    private Long sessionId;

    public CourseInfoViewModel(){}

    public CourseInfoViewModel(String courseName, String info, Long sessionId) {
        this.courseName = courseName;
        this.info = info;
        this.sessionId = sessionId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Long getSessionId() {
        return sessionId;
    }

    public void setSessionId(Long sessionId) {
        this.sessionId = sessionId;
    }
}
