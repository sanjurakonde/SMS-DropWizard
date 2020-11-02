package com.flipkart.service;

import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;

import java.util.List;

/**
 * The interface Professor service.
 */
public interface ProfessorService {
    /**
     * View students.
     *
     * @param professor the professor
     */
    public List<Student> viewStudents(Professor professor);

    /**
     * Gets course taught.
     *
     * @param professor the professor
     */
    void getCourseTaught(Professor professor);

    /**
     * Grade student.
     *
     * @param professor the professor
     * @param courseId  the course id
     * @param studentId the student id
     * @param grade     the grade
     */
    void gradeStudent(Professor professor, int courseId, int studentId, String grade);

    /**
     * Gets professor details.
     *
     * @param username the username
     * @return the professor details
     */
    Professor getProfessorDetails(String username);
}
