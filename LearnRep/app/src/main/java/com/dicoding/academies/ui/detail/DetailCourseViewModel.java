package com.dicoding.academies.ui.detail;

import androidx.lifecycle.ViewModel;

import com.dicoding.academies.data.CourseEntity;
import com.dicoding.academies.data.ModuleEntity;
import com.dicoding.academies.data.source.AcademyRepository;
import com.dicoding.academies.utils.DataDummy;

import java.util.ArrayList;
import java.util.List;

public class DetailCourseViewModel extends ViewModel {
    private String courseId;
    private AcademyRepository academyRepository;
    public DetailCourseViewModel(AcademyRepository mAcademyRepository) {
        this.academyRepository = mAcademyRepository;
    }

    public void setSelectedCourse(String courseId) {
        this.courseId = courseId;
    }

    public CourseEntity getCourse() {
        return academyRepository.getCourseWithModules(courseId);
    }

    public List<ModuleEntity> getModules() {
        return academyRepository.getAllModulesByCourse(courseId);
    }
}

