package com.dicoding.academies.ui.bookmark;

import androidx.lifecycle.ViewModel;

import com.dicoding.academies.data.CourseEntity;
import com.dicoding.academies.data.source.AcademyRepository;
import com.dicoding.academies.utils.DataDummy;

import java.util.List;

public class BookmarkViewModel extends ViewModel {
//    List<CourseEntity> getBookmarks() {
//        return DataDummy.generateDummyCourses();
//    }

    private AcademyRepository academyRepository;
    public BookmarkViewModel(AcademyRepository mAcademyRepository) {
        this.academyRepository = mAcademyRepository;
    }

    List<CourseEntity> getBookmarks() {
        return academyRepository.getBookmarkedCourses();
    }

}

