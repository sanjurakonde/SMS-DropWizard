package com.flipkart.dao;

import com.flipkart.bean.Course;
import com.flipkart.constants.SQLQueriesConstants;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;

/**
 * The type Catalogue dao.
 */
public class CatalogueDAOImpl implements CatalogueDAO {
    private static Logger logger = Logger.getLogger(CatalogueDAOImpl.class);
    /**
     * The Connection.
     */
    Connection connection = DBUtils.getConnection();

    /*
    returns list of all the courses present in the catalogue
     */
    @Override
    public ArrayList<Course> viewCatalog() {
        PreparedStatement stmt = null;
        // Store all courses from result set
        ArrayList<Course> courseList = new ArrayList<Course>();
        try {
            stmt = connection.prepareStatement(SQLQueriesConstants.VIEW_CATALOG_QUERY);
            ResultSet rs = stmt.executeQuery(SQLQueriesConstants.VIEW_CATALOG_QUERY);
            while(rs.next()) {
                Course course = new Course();
                course.setCourseId(rs.getInt("courseId"));
                course.setCourseName(rs.getString("courseName"));
                course.setDescription(rs.getString("courseDescription"));
                course.setFee(rs.getInt("fees"));
                courseList.add(course);
            }
        }catch(SQLException se){
            logger.error(se.getMessage());
        }catch(Exception e){
            logger.error(e.getMessage());
        }

        return courseList;
    }

    /*
    returns details of a course
     */
    @Override
    public Course viewCourseFromCatalog(int courseId) {
        PreparedStatement stmt = null;
        Course course = null;
        try {
            stmt = connection.prepareStatement(SQLQueriesConstants.VIEW_COURSE_QUERY);
            stmt.setInt(1, courseId);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                course = new Course();
                course.setCourseId(courseId);
                course.setCourseName(rs.getString("courseName"));
                course.setDescription(rs.getString(4));
                course.setFee(rs.getInt("fees"));
            }
            else {
                throw new CourseNotFoundException();
            }
        }catch(SQLException se){
            logger.error(se.getMessage());
        }catch(CourseNotFoundException ce){
            logger.error(ce.getMessage());
        }catch(Exception e){
            logger.error(e.getMessage());
        }
        return course;
    }
}
