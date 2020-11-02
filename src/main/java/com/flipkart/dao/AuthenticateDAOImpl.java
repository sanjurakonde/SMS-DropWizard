package com.flipkart.dao;

import com.flipkart.bean.Admin;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.bean.User;
import com.flipkart.constants.SQLQueriesConstants;
import com.flipkart.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.log4j.Logger;

/**
 * The type Authenticate dao.
 */
public class AuthenticateDAOImpl implements AuthenticateDAO {
    private static Logger logger = Logger.getLogger(AuthenticateDAOImpl.class);
    /**
     * The Connection.
     */
    Connection connection = DBUtils.getConnection();

    @Override
    public String logIn(String username, String password) {
        PreparedStatement stmt = null;
        String role = "";
        try {
            stmt = connection.prepareStatement(SQLQueriesConstants.LOGIN_QUERY);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                role = rs.getString("role");
            }

        }catch(SQLException se){
            logger.error(se.getMessage());
        }catch(Exception e){
            logger.error(e.getMessage());
        }
        return role;
    }

    @Override
    public void logOut(User user) {

    }

    /*
    register a user as student
     */
    @Override
    public void registerStudent(Student student, String password) {
        if(registerUser(student.getStudentId(), student.getUserName(), "student", password)) {
            PreparedStatement stmt = null;
            try {
                stmt = connection.prepareStatement(SQLQueriesConstants.REGISTER_STUDENT_QUERY);
                //stmt.setInt(1,student.getStudentId());
                stmt.setString(1, student.getStudentName());
                if(student.isHasScholarship())
                    stmt.setInt(2, 1);
                else
                    stmt.setInt(2,0);
                stmt.setString(3, student.getGender());
                stmt.setInt(4, student.getSemester());
                int rows = stmt.executeUpdate();
                if(rows > 0) {
                    logger.info("Successfully registered");
                }
                else {
                    logger.error("Couldn't register please try again!!");
                }
            }catch(SQLException se){
                logger.error(se.getMessage());
            }catch(Exception e){
                logger.error(e.getMessage());
            }
        }
        else {
            logger.info("Couldn't register please try again!!");
        }
    }

    /*
    register a user as professor
     */
    @Override
    public void registerProfessor(Professor professor, String password) {
        if(registerUser(professor.getProfessorId(), professor.getUserName(), "professor", password)) {
            PreparedStatement stmt = null;
            try {
                stmt = connection.prepareStatement(SQLQueriesConstants.REGISTER_PROFESSOR_QUERY);
                //stmt.setInt(1,professor.getProfessorId());
                stmt.setString(1, professor.getName());
                stmt.setString(2, professor.getGender());
                int rows = stmt.executeUpdate();
                if(rows > 0) {
                    logger.info("Successfully registered");
                }
                else {
                    logger.info("Couldn't register please try again!!");
                }

            }catch(SQLException se){
                logger.error(se.getMessage());
            }catch(Exception e){
                logger.error(e.getMessage());
            }
        }
        else {
            logger.info("Couldn't register please try again!!");
        }
    }

    /*
    register a user as admin
     */
    @Override
    public void registerAdmin(Admin admin, String password) {
        if(registerUser(admin.getAdminId(), admin.getUserName(), "admin", password)) {
            PreparedStatement stmt = null;
            try {
                stmt = connection.prepareStatement(SQLQueriesConstants.REGISTER_ADMIN_QUERY);
                //stmt.setInt(1,admin.getAdminId());
                stmt.setString(1, admin.getName());
                stmt.setString(2, admin.getGender());
                int rows = stmt.executeUpdate();
                if(rows > 0) {
                    logger.info("Successfully registered");
                }
                else {
                    logger.info("Couldn't register please try again!!");
                }
            }catch(SQLException se){
                logger.error(se.getMessage());
            }catch(Exception e){
                logger.error(e.getMessage());
            }
        }
        else {
            logger.info("Couldn't register please try again!!");
        }
    }

    /**
     * Register user boolean.
     *
     * @param userId   the user id
     * @param username the username
     * @param role     the role
     * @param password the password
     * @return the boolean
     */
/*
     Register a user
     */
    public boolean registerUser(int userId, String username, String role, String password) {
        int roleId = getRoleIdBasedOnGivenRole(role);
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(SQLQueriesConstants.REGISTER_USER_QUERY);
            //stmt.setInt(1, userId);
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.setInt(3, roleId);
            int rows1 = stmt.executeUpdate();
            if(rows1 > 0) {
                return true;
            }
            else {
                logger.info("Couldn't register please try again!!");
            }
            stmt.close();
        }catch(SQLException se) {
            logger.error(se.getMessage());
        }catch(Exception e) {
            logger.error(e.getMessage());
        }
        return false;
    }

    /**
     * Gets role id based on given role.
     *
     * @param role the role
     * @return the role id based on given role
     */
/*
     Get role id based on selected role
     */
    int getRoleIdBasedOnGivenRole(String role) {
        int roleId = 0;
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(SQLQueriesConstants.GET_ROLE_ID_QUERY);
            stmt.setString(1, role);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()) {
                return rs.getInt(1);
            }
            else {
                logger.error("Error no such role!!");
            }

        }catch(SQLException se) {
            logger.error(se.getMessage());
        }catch(Exception e) {
            logger.error(e.getMessage());
        }
        return roleId;

    }
}
