package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.User;
import com.flipkart.dao.AdminDAO;
import com.flipkart.dao.AdminDAOImpl;

import java.util.List;
import java.util.stream.Collectors;
import org.apache.log4j.Logger;

/**
 * The type Admin service.
 */
public class AdminServiceImpl implements AdminService {
    private static Logger logger = Logger.getLogger(AdminServiceImpl.class);
    /**
     * The Admin dao.
     */
    AdminDAO adminDAO = new AdminDAOImpl();

    @Override
    public boolean approveUser(User user) {
        try {
            return adminDAO.approveUser(user);
        } catch (Exception exception) {
            logger.error(exception.getMessage());
        }
        return false;
    }

    @Override
    public boolean deleteUser(int userId) {
        try {
            return adminDAO.deleteUser(userId);
        } catch (Exception exception) {
            logger.error(exception.getMessage());
        }
        return false;
    }

    @Override
    public boolean addCourse(Course course) {
        try {
            return adminDAO.addCourse(course);
        } catch (Exception exception) {
            logger.error(exception.getMessage());
        }
        return false;
    }

    @Override
    public boolean deleteCourse(Course course) {
        try {
            return adminDAO.deleteCourse(course);
        } catch (Exception exception) {
            logger.error(exception.getMessage());
        }
        return false;
    }

    @Override
    public void assignProfessor(Professor professor, int courseId) {
        try {
            adminDAO.assignProfessor(professor, courseId);
        } catch (Exception exception) {
            logger.error(exception.getMessage());
        }
    }

    @Override
    public List<User> viewUsers() {
        List<User> userList = adminDAO.viewUsers();
        return userList;
    }

    /**
     * Print users based on role.
     *
     * @param userList the user list
     * @param role     the role
     */
    public void printUsersBasedOnRole(List<User> userList, String role) {
        userList.stream().filter(user -> user.getRole().equals(role))
                .collect(Collectors.toList())
                .forEach(user -> logger.info(user.getId() + "\t" + user.getUserName()));
    }
}
