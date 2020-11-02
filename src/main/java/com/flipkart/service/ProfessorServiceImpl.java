package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.dao.ProfessorDAO;
import com.flipkart.dao.ProfessorDAOImpl;

import java.util.List;
import org.apache.log4j.Logger;

/**
 * The type Professor service.
 */
public class ProfessorServiceImpl implements ProfessorService {
    /**
     * The Professor dao.
     */
    ProfessorDAO professorDAO = new ProfessorDAOImpl();
    private static Logger logger = Logger.getLogger(ProfessorServiceImpl.class);

    @Override
    public List<Student> viewStudents(Professor professor) {
        return professorDAO.viewStudents(professor);
    }

    @Override
    public void getCourseTaught(Professor professor) {
        logger.info("--------------Course List--------------");
        logger.info("Course Id\tCourse Name\t\tCourse Description");
        List<Course> courseList = professorDAO.getCourseTaught(professor);
        courseList.forEach(course ->
                logger.info(course.getCourseId() + "\t\t" + course.getCourseName() + "\t\t\t" + course.getDescription())
        );
        logger.info("----------------------------------------");
    }

    @Override
    public void gradeStudent(Professor professor, int courseId, int studentId, String grade) {
        professorDAO.gradeStudent(professor, courseId, studentId, grade);
    }

    @Override
    public Professor getProfessorDetails(String username) {
        return professorDAO.getProfessorDetails(username);
    }
}
