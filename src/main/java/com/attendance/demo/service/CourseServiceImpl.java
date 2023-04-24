package com.attendance.demo.service;

import com.attendance.demo.model.entity.CourseEntity;
import com.attendance.demo.model.entity.SessionEntity;
import com.attendance.demo.model.entity.UserEntity;
import com.attendance.demo.model.view.CourseInfoViewModel;
import com.attendance.demo.repository.CourseRepository;
import com.attendance.demo.repository.SessionRepository;
import com.attendance.demo.repository.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{

    private final CourseRepository courseRepository;

    private final UserRepository userRepository;

    private final SessionRepository sessionRepository;

    public CourseServiceImpl(CourseRepository courseRepository, UserRepository userRepository, SessionRepository sessionRepository) {
        this.courseRepository = courseRepository;
        this.userRepository = userRepository;
        this.sessionRepository = sessionRepository;
    }


    @Override
    public void seedCourses() {

        if(this.courseRepository.findByCourseName("Software Development").isEmpty()) {
            CourseEntity softwareDevelopment = new CourseEntity();
            softwareDevelopment.setCourseName("Software Development");
            softwareDevelopment.setInfo("<<<some info about discipline>>>");
            softwareDevelopment.setStudents(
                    List.of(
                            this.userRepository.findByEmail("nedkiivanov@gmail.com").get(),
                            this.userRepository.findByEmail("georgiev02@gmail.com").get())
            );
            softwareDevelopment.setTeachers(
                    List.of(
                            this.userRepository.findByEmail("first@gmail.com").get(),
                            this.userRepository.findByEmail("third@gmail.com").get()
                    )
            );
            softwareDevelopment.setSessions(
                    List.of(
                            this.sessionRepository.findByName("C programming").get(),
                            this.sessionRepository.findByName("Java Programming").get(),
                            this.sessionRepository.findByName("SQL Database").get(),
                            this.sessionRepository.findByName("Test Session").get()
                    )
            );
            this.courseRepository.save(softwareDevelopment);
        }



        if(this.courseRepository.findByCourseName("Advanced Mathematics").isEmpty()) {
            CourseEntity advancedMaths = new CourseEntity();
            advancedMaths.setCourseName("Advanced mathematics");
            advancedMaths.setInfo("<<<some info about discipline>>>");
            advancedMaths.setStudents(
                    List.of(
                            this.userRepository.findByEmail("mitkoDMTRV@gmail.com").get()
                    )
            );
            advancedMaths.setTeachers(
                    List.of(
                            this.userRepository.findByEmail("fifth@gmail.com").get(),
                            this.userRepository.findByEmail("second@gmail.com").get()
                    )
            );
            advancedMaths.setSessions(
                    List.of(
                            this.sessionRepository.findByName("Advanced Mathematics").get(),
                            this.sessionRepository.findByName("Physics").get()
                    )
            );

            this.courseRepository.save(advancedMaths);
        }

        if(this.courseRepository.findByCourseName("Biology").isEmpty()) {
            CourseEntity biology = new CourseEntity();
            biology.setCourseName("Biology");
            biology.setInfo("<<<some info about discipline>>>");
            biology.setStudents(
                    List.of(
                            this.userRepository.findByEmail("todorovTodor@gmail.com").get()
                    )
            );
            biology.setTeachers(
                    List.of(
                            this.userRepository.findByEmail("sixth@gmail.com").get()
                    )
            );
            biology.setSessions(
                    List.of(
                            this.sessionRepository.findByName("Biology").get(),
                            this.sessionRepository.findByName("Chemistry").get()
                    )
            );
            this.courseRepository.save(biology);
        }

        if(this.courseRepository.findByCourseName("Law").isEmpty()) {
            CourseEntity law = new CourseEntity();
            law.setCourseName("Law");
            law.setInfo("<<<some info about discipline>>>");
            law.setStudents(
                    List.of(this.userRepository.findByEmail("martinez@gmail.com").get()
                    )
            );
            law.setTeachers(
                    List.of(
                            this.userRepository.findByEmail("fourth@gmail.com").get()
                    )
            );
            law.setSessions(
                    List.of(
                            this.sessionRepository.findByName("Bulgarian History").get(),
                            this.sessionRepository.findByName("History").get()
                    )
            );
            this.courseRepository.save(law);
        }

    }

    @Override
    public List<CourseInfoViewModel> getCourseInfoForCurrentTeacher(String teacherMail) {

        UserEntity teacher =  this.userRepository.findByEmail(teacherMail).orElseThrow(
                () -> new UsernameNotFoundException("Teacher with email:" + teacherMail + "not found.")
        );

        List<CourseInfoViewModel> courseInfo = new ArrayList<>();
        List<CourseEntity> teachersCourses = teacher.getTeacherCourse();
        if(teachersCourses!=null && !teachersCourses.isEmpty()){
            for(CourseEntity c : teachersCourses){

                List<SessionEntity> sessions = c.getSessions();
                Long sessionId = null;

                for(SessionEntity s : sessions){
                    if(s.getActive() != null && s.getActive() == true){
                        sessionId = s.getId();
                        break;
                    }
                }
                courseInfo.add(
                        new CourseInfoViewModel(
                                c.getCourseName(),
                                c.getInfo(),
                                sessionId
                        )
                );
            }
        }


        return courseInfo;
    }
}
