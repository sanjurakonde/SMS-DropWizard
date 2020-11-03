package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.exception.CourseNotFoundException;

import java.util.List;

/**
 * The interface Student service.
 */
public interface StudentService {
    /**
     * View registered courses.
     *
     * @param student the student
     * @return
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
     * View grades.
     *
     * @param student the student
     */
    void viewGrades(Student student);

    /**
     * Calculate total fee int.
     *
     * @param student the student
     * @return the int
     */
    int calculateTotalFee(Student student);

    /**
     * Make payment.
     *
     * @param student       the student
     * @param paymentMethod the payment method
     * @param fees          the fees
     */
    void makePayment(Student student, int paymentMethod, int fees);

    /**
     * Gets student details.
     *
     * @param name the name
     * @return the student details
     */
    Student getStudentDetails(String name);
}