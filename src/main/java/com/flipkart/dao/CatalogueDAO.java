package com.flipkart.dao;

import com.flipkart.bean.Course;

import java.util.ArrayList;

/**
 * The interface Catalogue dao.
 */
public interface CatalogueDAO {
    /**
     * View catalog array list.
     *
     * @return the array list
     */
    public ArrayList<Course> viewCatalog();

    /**
     * View course from catalog course.
     *
     * @param courseId the course id
     * @return the course
     */
    public Course viewCourseFromCatalog(int courseId);
}