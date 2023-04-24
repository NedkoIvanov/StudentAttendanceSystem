package com.attendance.demo.web;

import com.attendance.demo.model.binding.EditGradeValueBindingModel;
import com.attendance.demo.model.entity.GradeEntity;
import com.attendance.demo.model.view.GradeToEditViewModel;
import com.attendance.demo.service.GradeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.Valid;

import java.util.List;

@Controller
public class GradeController {

    private final GradeService gradeService;

    public GradeController(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    @GetMapping("/grades/edit")
    public String getGradesToEdit(Model model){

        List<GradeToEditViewModel> gradesToEdit = this.gradeService.findAllToEdit();

        model.addAttribute("allGrades",gradesToEdit);

        return "grades-edit";
    }

    @ModelAttribute("editValue")
    public EditGradeValueBindingModel editGradeValueBindingModel(){
        return new EditGradeValueBindingModel();
    }

    @PatchMapping("/grades/{id}/edit")
    public String editCurrentGrade(@PathVariable Long id,
                                   @Valid EditGradeValueBindingModel editGradeValueBindingModel,
                                   BindingResult bindingResult){

        if(bindingResult.hasErrors()) {
            return "redirect:/grades/" + id + "/edit";
        }

        this.gradeService.changeGradeValue(id,editGradeValueBindingModel);

        return "redirect:/grades/edit";
    }
}
