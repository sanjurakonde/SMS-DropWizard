package com.flipkart.rest;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.service.*;
import org.apache.log4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

// all operation related to the student
@Path("/student")
public class StudentController {

    private static final Logger logger = Logger.getLogger(StudentController.class);

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
        logger.info("Student is registered with username " + username);
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
    @Consumes("application/json")
    public List<Course> getRegisteredCourses(@PathParam("studentId") int studentId) {
        Student student = new Student();
        student.setStudentId(studentId);
        return studentService.viewRegisteredCourses(student);
    }

    // Select a course to register
    @POST
    @Path("/selectCourse/{studentId}/{courseId}")
    @Consumes("application/json")
    //@Produces(MediaType.APPLICATION_JSON)
    public Response registerCourse(@PathParam("studentId") int studentId, @PathParam("courseId") int courseId) throws CourseNotFoundException {
        Student student = new Student();
        student.setStudentId(studentId);
        studentService.selectCourse(student, courseId);
        //String result = "Saved "  + courseId + studentId;
        logger.info("Course with Id "  + courseId  + " is registered by student Id "+ studentId);
        return Response.status(201).entity("Course with Id "  + courseId  + " is registered by student Id "+ studentId).build();
    }

    // make payment
    @POST
    @Path("/makePayment/{studentId}/{paymentMethod}/{fees}")
    @Consumes("application/json")
    //@Produces(MediaType.APPLICATION_JSON)
    public Response makePayment(@PathParam("studentId") int studentId, @PathParam("paymentMethod") int paymentMethod, @PathParam("fees") int fees) {
        Student student = new Student();
        student.setStudentId(studentId);
        studentService.makePayment(student, paymentMethod, fees);
        logger.info("Made Payment for student with student Id " + studentId);
        String result = "Made Payment for student with student Id " + studentId;
        return Response.status(201).entity(result).build();
    }

    // delete course from registered courses
    @DELETE
    @Path("/dropCourse/{studentId}/{courseId}")
    public Response dropCourse(@PathParam("studentId") int studentId, @PathParam("courseId") int courseId) throws CourseNotFoundException {
        studentService.dropCourse(courseId, studentId);
        logger.info("The course " + courseId + " for student " + studentId + "deleted" );
        return Response.status(200).entity("The course " + courseId + " for student " + studentId + " deleted" ).build();
    }
}
