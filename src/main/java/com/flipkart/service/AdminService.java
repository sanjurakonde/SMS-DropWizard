package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.User;

import java.util.List;

/**
 * The interface Admin service.
 */
public interface AdminService {
    /**
     * Approve user boolean.
     *
     * @param user the user
     * @return the boolean
     */
    boolean approveUser(User user);

    /**
     * Delete user boolean.
     *
     * @param userId the user id
     * @return the boolean
     */
    boolean deleteUser(int userId);

    /**
     * Add course boolean.
     *
     * @param course the course
     * @return the boolean
     */
    boolean addCourse(Course course);

    /**
     * Delete course boolean.
     *
     * @param course the course
     * @return the boolean
     */
    boolean deleteCourse(Course course);

    /**
     * Assign professor.
     *
     * @param professor the professor
     * @param courseId  the course id
     */
    void assignProfessor(Professor professor, int courseId);

    /**
     * View users.
     */
    List<User> viewUsers();
}
