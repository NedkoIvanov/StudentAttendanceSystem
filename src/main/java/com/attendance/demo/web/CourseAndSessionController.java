package com.attendance.demo.web;

import com.attendance.demo.model.binding.SetAttendanceBindingModel;
import com.attendance.demo.service.CourseService;
import com.attendance.demo.service.SessionService;
import com.attendance.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.Valid;

@Controller
public class CourseAndSessionController {

    private final SessionService sessionService;

    private final CourseService courseService;

    private final UserService userService;

    public CourseAndSessionController(SessionService sessionService, CourseService courseService, UserService userService) {
        this.sessionService = sessionService;
        this.courseService = courseService;
        this.userService = userService;
    }


    @GetMapping("/{email}/courses")
    public String getCourse(@PathVariable String email, Model model){
        model.addAttribute("courseView",this.courseService.getCourseInfoForCurrentTeacher(email));
        return "course-info";
    }

    @GetMapping("/session/{id}/all")
    public String getSession(@PathVariable Long id,Model model){

        model.addAttribute("sessionView",this.sessionService.currentSessionStudents(id));


        return "current-session";
    }


    @ModelAttribute("setAttendance")
    public SetAttendanceBindingModel getSetDateBindingModel() {
        return new SetAttendanceBindingModel();
    }

    @PatchMapping("/session/{id}/attendance")
    public String setAttendance(@PathVariable Long id,
                                @Valid SetAttendanceBindingModel setAttendanceBindingModel,
                                BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            //return "redirect:"
         //   return "redirect:/session/" + id + "/attendance";
        }
        this.userService.setAttendance(setAttendanceBindingModel,id);

        return "redirect:/";
    }









}
