package com.flipkart.dao;

import com.dropwizard.App;
import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.User;
import com.flipkart.constants.SQLQueriesConstants;
import com.flipkart.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;

/**
 * The type Admin dao.
 */
public class AdminDAOImpl implements AdminDAO {
    private static final Logger logger = Logger.getLogger(AdminDAOImpl.class);
    //private static Logger logger = Logger.getLogger(AdminDAOImpl.class);
    /**
     * The Connection.
     */
    Connection connection = DBUtils.getConnection();

    /*
    approves a user
     */
    @Override
    public boolean approveUser(User user) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(SQLQueriesConstants.APPROVE_USER_QUERY);
            stmt.setInt(1,user.getId());
            int rows = stmt.executeUpdate();
            logger.info(rows + " users approved");
        }catch(SQLException se) {
            logger.error(se.getMessage());
        }catch(Exception e) {
            logger.error(e.getMessage());
        }
        return true;
    }

    /*
    deletes a user
     */
    @Override
    public boolean deleteUser(int userId) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(SQLQueriesConstants.DELETE_USER_QUERY);
            stmt.setInt(1,userId);
            int rows = stmt.executeUpdate();
            logger.info(rows + " deleted");
        }catch(SQLException se) {
            logger.error(se.getMessage());
        }catch(Exception e) {
            logger.error(e.getMessage());
        }
        return true;
    }

    /*
    adds a course to the catalogue
     */
    @Override
    public boolean addCourse(Course course) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(SQLQueriesConstants.ADD_NEW_COURSE_QUERY);
            //stmt.setInt(1,course.getCourseId());
            stmt.setString(1, course.getCourseName());
            stmt.setInt(2, course.getFee());
            stmt.setString(3, course.getDescription());
            stmt.setInt(4,course.getCatalogId());
            int rows = stmt.executeUpdate();
            logger.info(rows + " course added");
        }catch(SQLException se) {
            logger.error(se.getMessage());
        }catch(Exception e) {
            logger.error(e.getMessage());
        }
        return true;
    }

    /*
    deletes a course from catalogue
     */
    @Override
    public boolean deleteCourse(Course course) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(SQLQueriesConstants.DELETE_COURSE_QUERY);
            stmt.setInt(1,course.getCourseId());
            int rows = stmt.executeUpdate();
            logger.info(rows + " deleted");
        }catch(SQLException se) {
            logger.error(se.getMessage());
        }catch(Exception e) {
            logger.error(e.getMessage());
        }
        return true;
    }

    /*
    returns a list of all users
     */
    @Override
    public ArrayList<User> viewUsers() {
        PreparedStatement stmt = null;

        ArrayList<User> userList = new ArrayList<User>();

        try {
            stmt = connection.prepareStatement(SQLQueriesConstants.VIEW_USERS_QUERY);
            ResultSet rs = stmt.executeQuery(SQLQueriesConstants.VIEW_USERS_QUERY);
            while(rs.next()) {
                User user = new User();
                user.setId(rs.getInt(1));
                user.setUserName(rs.getString(2));
                user.setRole(rs.getString(3));
                userList.add(user);
            }

        }catch(SQLException se) {
            logger.info(se.getMessage());

        }catch(Exception e) {
            logger.info(e.getMessage());
        }
        return userList;
    }

    /*
    assigns a professor to a course
     */
    @Override
    public void assignProfessor(Professor professor, int courseId) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(SQLQueriesConstants.ASSIGN_PROFESSOR_QUERY);
            stmt.setInt(2, professor.getProfessorId());
            stmt.setInt(1, courseId);
            int rows = stmt.executeUpdate();
            logger.info(rows + " updated");
        }catch(SQLException se) {
            logger.error(se.getMessage());
        }catch(Exception e) {
            logger.error(e.getMessage());
        }


    }
}