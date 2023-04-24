package com.attendance.demo.DBInit;

import com.attendance.demo.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SeedDB implements CommandLineRunner {
    private final CourseService courseService;
    private final GradeService gradeService;
    private final SessionService sessionService;
    private final UserService userService;
    private final RoleService roleService;


    public SeedDB(CourseService courseService, GradeService gradeService,
                  SessionService sessionService, UserService userService, RoleService roleService){
        this.courseService = courseService;
        this.gradeService = gradeService;
        this.roleService = roleService;
        this.sessionService = sessionService;
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.roleService.seedRoles();
        this.userService.seedStudents();
        this.userService.seedTeachers();
        this.sessionService.seedSessions();
        this.courseService.seedCourses();
        this.sessionService.seedSessionCourse();
        this.gradeService.seedGrades();
    }
}
