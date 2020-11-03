package com.flipkart.dao;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.exception.CourseNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * The interface Student dao.
 */
public interface StudentDAO {
    /**
     * View registered courses array list.
     *
     * @param student the student
     * @return the array list
     */
    List<Course> viewRegisteredCourses(Student student);

    /**
     * Select course.
     *
     * @param student  the student
     * @param courseId the course id
     * @throws CourseNotFoundException the course not found exception
     */
    void selectCourse(Student student, int courseId) throws CourseNotFoundException;

    /**
     * Drop course.
     *
     * @param courseId  the course id
     * @param studentId the student id
     * @throws CourseNotFoundException the course not found exception
     */
    void dropCourse(int courseId, int studentId) throws CourseNotFoundException;

    /**
     * Number of registered course int.
     *
     * @param student the student
     * @return the int
     */
    int numberOfRegisteredCourse(Student student);

    /**
     * View grades map.
     *
     * @param student the student
     * @return the map
     */
    Map<String, String> viewGrades(Student student);

    /**
     * Calculate total fee int.
     *
     * @param student the student
     * @return the int
     */
    int calculateTotalFee(Student student);

    /**
     * Make payment string.
     *
     * @param student       the student
     * @param paymentMethod the payment method
     * @param fees          the fees
     * @return the string
     */
    String makePayment(Student student, int paymentMethod, int fees);

    /**
     * Gets student details.
     *
     * @param name the name
     * @return the student details
     */
    Student getStudentDetails(String name);
}
