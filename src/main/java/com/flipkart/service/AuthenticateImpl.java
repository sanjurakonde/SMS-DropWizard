package com.flipkart.service;

import com.flipkart.bean.Admin;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.bean.User;
import com.flipkart.dao.AuthenticateDAO;
import com.flipkart.dao.AuthenticateDAOImpl;;

/**
 * The type Authenticate.
 */
public class AuthenticateImpl implements  Authenticate {

    /**
     * The Authenticate.
     */
    AuthenticateDAO authenticate = new AuthenticateDAOImpl();
    @Override
    public String logIn(String username, String password) {
        return authenticate.logIn(username, password);
    }

    @Override
    public void logOut(User user) {
        authenticate.logOut(user);
    }

    @Override
    public void registerStudent(Student student, String password) {
        authenticate.registerStudent(student, password);
    }

    @Override
    public void registerProfessor(Professor professor, String password) {
        authenticate.registerProfessor(professor, password);
    }

    @Override
    public void registerAdmin(Admin admin, String password) {
        authenticate.registerAdmin(admin, password);
    }
}
