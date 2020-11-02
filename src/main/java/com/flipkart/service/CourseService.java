package com.flipkart.service;

import com.flipkart.bean.Course;

import java.util.List;

/**
 * The interface Course service.
 */
public interface CourseService {
    /**
     * View course.
     *
     * @param course the course
     */
    void viewCourse(Course course);

    /**
     * List courses.
     */
    List<Course> listCourses();
}