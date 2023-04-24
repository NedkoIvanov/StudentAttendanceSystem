package com.attendance.demo.service;

import com.attendance.demo.exception.ObjectNotFoundException;
import com.attendance.demo.model.binding.EditGradeValueBindingModel;
import com.attendance.demo.model.entity.Enums.GradeEnum;
import com.attendance.demo.model.entity.GradeEntity;
import com.attendance.demo.model.view.GradeToEditViewModel;
import com.attendance.demo.repository.GradeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class GradeServiceImpl implements GradeService{

    private final GradeRepository gradeRepository;

    public GradeServiceImpl(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    @Override
    public void seedGrades() {
        long count = this.gradeRepository.count();
        if(count!=0){
            return;
        }
        List<GradeEntity> grades = new ArrayList<>();
        List<GradeEnum> enums = Arrays.asList(GradeEnum.values());
        for(int i=0;i<enums.size();i++) {
            grades.add(new GradeEntity(enums.get(i)));
        }
        this.gradeRepository.saveAll(grades);
    }

    @Override
    public List<GradeToEditViewModel> findAllToEdit() {

        List<GradeEntity> allGrades = this.gradeRepository.findAll();
        List<GradeToEditViewModel> gradeView = new ArrayList<>();

        if(allGrades!=null && !allGrades.isEmpty()){
            for(GradeEntity g : allGrades){

                gradeView.add(
                        new GradeToEditViewModel(
                                g.getId(),
                                g.getGrades().toString(),
                                g.getMark()
                        )
                );
            }

        }
        return gradeView;
    }

    @Override
    public void changeGradeValue(Long id, EditGradeValueBindingModel editGradeValueBindingModel) {

        GradeEntity grade = this.gradeRepository.findById(id).
                orElseThrow( () -> new ObjectNotFoundException("GradeEntity with requested id=" + id + "not found."));
        grade.setMark(editGradeValueBindingModel.getMark());
        this.gradeRepository.save(grade);

    }
}
