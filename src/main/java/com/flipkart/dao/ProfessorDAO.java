package com.flipkart.dao;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;

import java.util.List;

/**
 * The interface Professor dao.
 */
public interface ProfessorDAO {
    /**
     * View students.
     *
     * @param professor the professor
     * @return
     */
    public List<Student> viewStudents(Professor professor);

    /**
     * Gets course taught.
     *
     * @param professor the professor
     * @return the course taught
     */
    public List<Course> getCourseTaught(Professor professor);

    /**
     * Grade student.
     *
     * @param professor the professor
     * @param courseId  the course id
     * @param studentId the student id
     * @param grade     the grade
     */
    public void gradeStudent(Professor professor, int courseId, int studentId, String grade );

    /**
     * Gets professor details.
     *
     * @param username the username
     * @return the professor details
     */
    Professor getProfessorDetails(String username);
}
