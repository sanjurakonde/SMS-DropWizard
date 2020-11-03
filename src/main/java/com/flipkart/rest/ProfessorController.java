package com.flipkart.rest;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.service.*;
import org.apache.log4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

// all operation related to the professor
@Path("/professor")
public class ProfessorController {

    private static final Logger logger = Logger.getLogger(ProfessorController.class);
    ProfessorService professorService = new ProfessorServiceImpl();

    // register professor
    @POST
    @Path("/register/{name}/{username}/{password}/{gender}")
    @Consumes("application/json")
    public Response registerProfessor(@PathParam("name") String name, @PathParam("username") String username,
                                    @PathParam("password") String password, @PathParam("gender") String gender)
    {
        Authenticate authenticate = new AuthenticateImpl();
        Professor professor = new Professor();
        professor.setName(name);
        professor.setUserName(username);
        professor.setGender(gender);
        authenticate.registerProfessor(professor, password);
        logger.info("Professor is registered with username " + username);
        return Response.status(201).entity("User with username " + username + " is successfully registered").build();
    }

    // view all the courses
    @GET
    @Path("/viewCourses")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Course> viewCourses()
    {
        CourseService courseService = new CourseServiceImpl();
        return courseService.listCourses();
    }

    // view student the professor teaches to
    @GET
    @Path("/viewStudentsTaught/{professorId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes("application/json")
    public List<Student> viewStudents(@PathParam("professorId") int professorId)
    {
        Professor professor = new Professor();
        professor.setProfessorId(professorId);
        return professorService.viewStudents(professor);
    }

    // grade the students
    @PUT
    @Path("gradeStudent/{professorId}/{studentId}/{courseId}/{grade}")
    @Consumes("application/json")
    //@Produces(MediaType.APPLICATION_JSON)
    public Response gradeStudent(@PathParam("professorId") int professorId, @PathParam("studentId") int studentId,
                                 @PathParam("courseId") int courseId, @PathParam("grade") String grade) {
        Professor professor = new Professor();
        professor.setProfessorId(professorId);
        professorService.gradeStudent(professor, courseId, studentId, grade);
        String result = "Grades for student Id " + studentId + " with course " + courseId + "updated with grade " + grade;
        logger.info(result);
        return Response.status(200).entity(result).build();
    }


}
