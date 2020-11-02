package com.flipkart.service;

import com.flipkart.bean.Admin;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.bean.User;

/**
 * The interface Authenticate.
 */
public interface Authenticate {
    /**
     * Log in string.
     *
     * @param username the username
     * @param password the password
     * @return the string
     */
    String logIn(String username, String password);

    /**
     * Log out.
     *
     * @param user the user
     */
    void logOut(User user);

    /**
     * Register student.
     *
     * @param student  the student
     * @param password the password
     */
    void registerStudent(Student student, String password);

    /**
     * Register professor.
     *
     * @param professor the professor
     * @param password  the password
     */
    void registerProfessor(Professor professor, String password);

    /**
     * Register admin.
     *
     * @param admin    the admin
     * @param password the password
     */
    public void registerAdmin(Admin admin, String password);
}
