package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.dao.CatalogueDAO;
import com.flipkart.dao.CatalogueDAOImpl;

import java.util.List;
import org.apache.log4j.Logger;

/**
 * The type Course service.
 */
public class CourseServiceImpl implements CourseService {
    /**
     * The Catalogue dao.
     */
    CatalogueDAO catalogueDAO = new CatalogueDAOImpl();
    private static Logger logger = Logger.getLogger(CourseServiceImpl.class);
    @Override
    public void viewCourse(Course course) {
        catalogueDAO.viewCourseFromCatalog(course.getCourseId());
    }

    @Override
    public List<Course> listCourses() {
        List<Course> courses = catalogueDAO.viewCatalog();
        return courses;
    }
}