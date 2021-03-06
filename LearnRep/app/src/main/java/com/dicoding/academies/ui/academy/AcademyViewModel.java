package com.dicoding.academies.ui.academy;

import androidx.lifecycle.ViewModel;

import com.dicoding.academies.data.CourseEntity;
import com.dicoding.academies.data.source.AcademyRepository;
import com.dicoding.academies.utils.DataDummy;

import java.util.List;

public class AcademyViewModel extends ViewModel {

    private AcademyRepository academyRepository;
    public AcademyViewModel(AcademyRepository mAcademyRepository) {
        this.academyRepository = mAcademyRepository;
    }

    public List<CourseEntity> getCourses() {
        return academyRepository.getAllCourses();
    }
}

