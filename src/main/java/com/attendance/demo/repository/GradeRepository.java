package com.attendance.demo.repository;

import com.attendance.demo.model.entity.Enums.GradeEnum;
import com.attendance.demo.model.entity.GradeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeRepository extends JpaRepository<GradeEntity, Long> {

    @Query("SELECT g FROM GradeEntity g WHERE g.grades = :gradesName")
    GradeEntity findByGrade(@Param("gradesName") GradeEnum gradesName);
}
