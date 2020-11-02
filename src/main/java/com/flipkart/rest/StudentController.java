package com.flipkart.rest;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.service.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

// all operation related to the student
@Path("/student")
public class StudentController {

    StudentService studentService = new StudentServiceImpl();

    // register a student
    @POST
    @Path("/register/{name}/{username}/{password}/{scholarship}/{semester}/{gender}")
    @Consumes("application/json")
    public Response registerStudent(@PathParam("name") String studentName, @PathParam("scholarship") boolean hasScholarship,
                                    @PathParam("semester") int semester, @PathParam("gender") String gender,
                                    @PathParam("username") String username, @PathParam("password") String password)
    {
        Authenticate authenticate = new AuthenticateImpl();
        Student student = new Student();
        student.setStudentName(studentName);
        student.setHasScholarship(hasScholarship);
        student.setSemester(semester);
        student.setUserName(username);
        student.setGender(gender);
        authenticate.registerStudent(student, password);
        return Response.status(201).entity("User with username " + username + " is successfully registered").build();
    }

    //view all the courses
    @GET
    @Path("/viewCourses")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Course> viewCourses()
    {
        CourseService courseService = new CourseServiceImpl();
        return courseService.listCourses();
    }

    //view registered courses
    @GET
    @Path("/viewRegisteredCourses/{studentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Course> getRegisteredCourses(@PathParam("studentId") int studentId) {
        Student student = new Student();
        student.setStudentId(studentId);
        return studentService.viewRegisteredCourses(student);
    }

    // Select a course to register
    @PUT
    @Path("/selectCourse/{studentId}/{courseId}")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addCourses(@PathParam("studentId") int studentId, @PathParam("courseId") int courseId) throws CourseNotFoundException {
        Student student = new Student();
        student.setStudentId(studentId);
        studentService.selectCourse(student, courseId);
        String result = "Saved "  + courseId + studentId;
        return Response.status(201).entity(result).build();
    }

    // make payment
    @POST
    @Path("/makePayment/{studentId}/{paymentMethod}/{fees}")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response makePayment(@PathParam("studentId") int studentId, @PathParam("paymentMethod") int paymentMethod, @PathParam("fees") int fees) {
        Student student = new Student();
        student.setStudentId(studentId);
        studentService.makePayment(student, paymentMethod, fees);
        String result = "Made Payment for student with student Id " + studentId;
        return Response.status(201).entity(result).build();
    }

    // delete course from registered courses
    @DELETE
    @Path("/deleteCourse/{studentId}/{courseId}")
    public Response deleteCourse(@PathParam("studentId") int studentId, @PathParam("courseId") int courseId) throws CourseNotFoundException {
        studentService.dropCourse(courseId, studentId);
        return Response.status(200).entity("The course " + courseId + " for student " + studentId + "deleted" ).build();
    }
}
