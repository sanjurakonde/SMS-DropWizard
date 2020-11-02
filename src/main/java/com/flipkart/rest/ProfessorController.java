package com.flipkart.rest;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.service.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

// all operation related to the professor
@Path("/professor")
public class ProfessorController {

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
    public List<Student> viewStudents(@PathParam("professorId") int professorId)
    {
        Professor professor = new Professor();
        professor.setProfessorId(professorId);
        return professorService.viewStudents(professor);
    }

    // grade the students
    @POST
    @Path("gradeStudent/{professorId}/{studentId}/{courseId}/{grade}")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response gradeStudent(@PathParam("professorId") int professorId, @PathParam("studentId") int studentId,
                                 @PathParam("courseId") int courseId, @PathParam("grade") String grade) {
        Professor professor = new Professor();
        professor.setProfessorId(professorId);
        professorService.gradeStudent(professor, courseId, studentId, grade);
        String result = "Grades for student Id " + studentId + " with course " + courseId + "updated with grade " + grade;
        return Response.status(201).entity(result).build();
    }


}
