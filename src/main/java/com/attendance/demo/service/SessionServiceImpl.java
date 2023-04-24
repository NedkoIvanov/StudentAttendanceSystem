package com.attendance.demo.service;

import com.attendance.demo.exception.ObjectNotFoundException;
import com.attendance.demo.model.entity.Enums.GradeEnum;
import com.attendance.demo.model.entity.GradeEntity;
import com.attendance.demo.model.entity.SessionEntity;
import com.attendance.demo.model.entity.UserEntity;
import com.attendance.demo.model.view.StudentTableViewModel;
import com.attendance.demo.repository.CourseRepository;
import com.attendance.demo.repository.GradeRepository;
import com.attendance.demo.repository.SessionRepository;
import com.attendance.demo.repository.UserRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import java.util.ArrayList;
import java.util.List;

@Service
public class SessionServiceImpl implements SessionService{

    private final SessionRepository sessionRepository;

    private final UserRepository userRepository;

    private final GradeRepository gradeRepository;

    private final CourseRepository courseRepository;

    private boolean isActive = false;


    public SessionServiceImpl(SessionRepository sessionRepository, UserRepository userRepository,
                              GradeRepository gradeRepository, CourseRepository courseRepository) {
        this.sessionRepository = sessionRepository;
        this.userRepository = userRepository;
        this.gradeRepository = gradeRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public void seedSessions() {


        if(this.sessionRepository.count() != 10l) {

            SessionEntity physics = new SessionEntity();
            physics.setName("Physics");
            physics.setInfo("<<<Some info about discipline>>>");
            physics.setTime("12:30");
            physics.setDay("TUESDAY,WEDNESDAY");
            physics.setTeacher(this.userRepository.findByEmail("second@gmail.com").get());
            this.sessionRepository.save(physics);

            SessionEntity advancedMaths = new SessionEntity();
            advancedMaths.setName("Advanced Mathematics");
            advancedMaths.setInfo("<<<Some info about discipline>>>");
            advancedMaths.setTime("8:30");
            advancedMaths.setDay("TUESDAY,WEDNESDAY");
            advancedMaths.setTeacher(this.userRepository.findByEmail("fifth@gmail.com").get());
            this.sessionRepository.save(advancedMaths);

            SessionEntity cProgramming = new SessionEntity();
            cProgramming.setName("C Programming");
            cProgramming.setInfo("<<<Some info about discipline>>>");
            cProgramming.setTime("10:30");
            cProgramming.setDay("MONDAY,WEDNESDAY,FRIDAY");
            cProgramming.setTeacher(this.userRepository.findByEmail("first@gmail.com").get());
            this.sessionRepository.save(cProgramming);

            SessionEntity javaProgramming = new SessionEntity();
            javaProgramming.setName("Java Programming");
            javaProgramming.setInfo("<<<Some info about discipline>>>");
            javaProgramming.setTime("12:30");
            javaProgramming.setDay("MONDAY,WEDNESDAY,FRIDAY");
            javaProgramming.setTeacher(this.userRepository.findByEmail("first@gmail.com").get());
            this.sessionRepository.save(javaProgramming);

            SessionEntity test = new SessionEntity();
            test.setName("Test Session");
            test.setInfo("Some info about Test Session.");
            test.setActive(true);
            test.setTeacher(this.userRepository.findByEmail("first@gmail.com").get());
            this.sessionRepository.save(test);

            SessionEntity sqlDatabase = new SessionEntity();
            sqlDatabase.setName("SQL Database");
            sqlDatabase.setInfo("<<<Some info about discipline>>>");
            sqlDatabase.setTime("14:30");
            sqlDatabase.setDay("MONDAY,WEDNESDAY,FRIDAY");
            sqlDatabase.setTeacher(this.userRepository.findByEmail("third@gmail.com").get());
            this.sessionRepository.save(sqlDatabase);

            SessionEntity biology = new SessionEntity();
            biology.setName("Biology");
            biology.setInfo("<<<Some info about discipline>>>");
            biology.setTime("11:30");
            biology.setDay("TUESDAY,FRIDAY");
            biology.setTeacher(this.userRepository.findByEmail("sixth@gmail.com").get());
            this.sessionRepository.save(biology);

            SessionEntity chemistry = new SessionEntity();
            chemistry.setName("Chemistry");
            chemistry.setInfo("<<<Some info about discipline>>>");
            chemistry.setTime("9:30");
            chemistry.setDay("TUESDAY,WEDNESDAY");
            chemistry.setTeacher(this.userRepository.findByEmail("sixth@gmail.com").get());
            this.sessionRepository.save(chemistry);

            SessionEntity history = new SessionEntity();
            history.setName("History");
            history.setInfo("<<<Some info about discipline>>>");
            history.setTime("13:30");
            history.setDay("MONDAY,TUESDAY");
            history.setTeacher(this.userRepository.findByEmail("fourth@gmail.com").get());
            this.sessionRepository.save(history);

            SessionEntity bulgarianHistory = new SessionEntity();
            bulgarianHistory.setName("Bulgarian History");
            bulgarianHistory.setInfo("<<<Some info about discipline");
            bulgarianHistory.setTime("16:15");
            bulgarianHistory.setDay("TUESDAY,WEDNESDAY");
            bulgarianHistory.setTeacher(this.userRepository.findByEmail("fourth@gmail.com").get());
            this.sessionRepository.save(bulgarianHistory);

        }

    }


    @Override
    public void seedSessionCourse(){

        SessionEntity physics = this.sessionRepository.findByName("Physics").orElseThrow(
                () -> new ObjectNotFoundException("Object with name Physics not found.")
        );

        SessionEntity advancedMathematics = this.sessionRepository.findByName("Advanced Mathematics").orElseThrow(
                () -> new ObjectNotFoundException("Object with name Advance Mathematics not found.")
        );

        SessionEntity cProgramming = this.sessionRepository.findByName("C Programming").orElseThrow(
                () -> new ObjectNotFoundException("Object with name cProgramming not found.")
        );

        SessionEntity javaProgramming = this.sessionRepository.findByName("Java Programming").orElseThrow(
                () -> new ObjectNotFoundException("Object with name Java Programming not found.")
        );

        SessionEntity sqlDatabase = this.sessionRepository.findByName("Sql Database").orElseThrow(
                () -> new ObjectNotFoundException("Object with name Sql Database not found.")
        );

        SessionEntity testSession = this.sessionRepository.findByName("Test Session").orElseThrow(
                () -> new ObjectNotFoundException("Object with name Test Session not found."));

        SessionEntity biology = this.sessionRepository.findByName("Biology").orElseThrow(
                () -> new ObjectNotFoundException("Object with name Sql Database not found.")
        );

        SessionEntity chemistry = this.sessionRepository.findByName("Chemistry").orElseThrow(
                () -> new ObjectNotFoundException("Object with name Chemistry not found.")
        );
        SessionEntity history = this.sessionRepository.findByName("History").orElseThrow(
                () -> new ObjectNotFoundException("Object with name Sql Database not found.")
        );
        SessionEntity bulgarianHistory = this.sessionRepository.findByName("Bulgarian History").orElseThrow(
                () -> new ObjectNotFoundException("Object with name Bulgarian History not found.")
        );

        if(physics.getCourse() == null) {
            physics.setCourse(this.courseRepository.findByCourseName("Advanced mathematics").get());
            this.sessionRepository.save(physics);
        }
        if(advancedMathematics.getCourse() == null){
            advancedMathematics.setCourse(this.courseRepository.findByCourseName("Advanced mathematics").get());
            this.sessionRepository.save(advancedMathematics);
        }
        if(cProgramming.getCourse() == null){
            cProgramming.setCourse(this.courseRepository.findByCourseName("Software Development").get());
            this.sessionRepository.save(cProgramming);
        }
        if(javaProgramming.getCourse() == null){
            cProgramming.setCourse(this.courseRepository.findByCourseName("Software Development").get());
            this.sessionRepository.save(cProgramming);
        }
        if(javaProgramming.getCourse() == null){
            javaProgramming.setCourse(this.courseRepository.findByCourseName("Software Development").get());
            this.sessionRepository.save(javaProgramming);
        }

        if(sqlDatabase.getCourse() == null) {
            sqlDatabase.setCourse(this.courseRepository.findByCourseName("Software Development").get());
            this.sessionRepository.save(sqlDatabase);
        }

        if(javaProgramming.getCourse() == null) {
            javaProgramming.setCourse(this.courseRepository.findByCourseName("Software Development").get());
            this.sessionRepository.save(javaProgramming);
        }

        if(testSession.getCourse() == null) {
            testSession.setCourse(this.courseRepository.findByCourseName("Software Development").get());
            this.sessionRepository.save(testSession);
        }

        if(biology.getCourse() == null) {
            biology.setCourse(this.courseRepository.findByCourseName("Biology").get());
            this.sessionRepository.save(biology);
        }

        if(chemistry.getCourse() == null) {
            chemistry.setCourse(this.courseRepository.findByCourseName("Biology").get());
            this.sessionRepository.save(chemistry);
        }

        if(history.getCourse() == null) {
            history.setCourse(this.courseRepository.findByCourseName("Law").get());
            this.sessionRepository.save(history);
        }

        if(bulgarianHistory.getCourse() == null) {
            bulgarianHistory.setCourse(this.courseRepository.findByCourseName("Law").get());
            this.sessionRepository.save(bulgarianHistory);
        }

    }

    @Override
    public List<StudentTableViewModel> currentSessionStudents(Long id) {
        SessionEntity currentSession = this.sessionRepository
                .findById(id)
                .orElseThrow(
                        () -> new ObjectNotFoundException("Session with id:" + id + " not found!"));

        List<StudentTableViewModel> studentView = new ArrayList<>();

        List<UserEntity> studentsInSession = currentSession.getCourse().getStudents();

        List<GradeEnum> grades = new ArrayList<>();

        for(GradeEntity g : this.gradeRepository.findAll()){
            grades.add(g.getGrades());
        }

        if(studentsInSession != null && !studentsInSession.isEmpty()){
            for(UserEntity students : studentsInSession){
                studentView.add(
                        new StudentTableViewModel(
                                currentSession.getName(),
                                students.getId(),
                                students.getFirstName(),
                                students.getFamilyName(),
                                students.getEmail(),
                                grades
                        )
                );
            }
        }
        return studentView;
    }


    @Scheduled(fixedRate = 60000)
    public void activity() {

        List<SessionEntity> sessions = this.sessionRepository.findAll();
        String days = "";
        String time = "";
        for(SessionEntity s : sessions){

            days = s.getDay();
            time = s.getTime();

            String[] desiredDay = days.split(",");
            String[] desiredTime = time.split(":");

            int desiredH = Integer.parseInt(desiredTime[0]);
            int desiredM = Integer.parseInt(desiredTime[1]);

            LocalDateTime startTime = LocalDateTime.of(LocalDate.now(), LocalTime.of(desiredH, desiredM));
            LocalDateTime endTime = startTime.plusHours(1).plusMinutes(30);

            LocalDateTime currentTime = LocalDateTime.now();
            DayOfWeek currentDay = currentTime.getDayOfWeek();

            for(String d : desiredDay){
                if(!d.equals(currentDay.toString())){
                    isActive = false;
                    s.setActive(false);

                }
            }
            if (currentDay == DayOfWeek.SATURDAY || currentDay == DayOfWeek.SUNDAY) {
                isActive = false;
                s.setActive(false);

            }

            if (currentTime.isAfter(startTime) && currentTime.isBefore(endTime)) {
                isActive = true;
                s.setActive(true);

            } else {
                isActive = false;
                s.setActive(false);

            }
            this.sessionRepository.save(s);
        }
    }

}
