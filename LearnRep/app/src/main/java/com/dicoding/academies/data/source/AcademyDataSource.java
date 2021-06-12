package com.dicoding.academies.data.source;

import com.dicoding.academies.data.CourseEntity;
import com.dicoding.academies.data.ModuleEntity;

import java.util.List;

public interface AcademyDataSource {
    List<CourseEntity> getAllCourses();

    CourseEntity getCourseWithModules(String courseId);

    List<ModuleEntity> getAllModulesByCourse(String courseId);

    List<CourseEntity> getBookmarkedCourses();

    ModuleEntity getContent(String courseId, String moduleId);
}
