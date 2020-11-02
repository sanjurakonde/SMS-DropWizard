package com.flipkart.rest;

import com.flipkart.bean.Admin;
import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.User;
import com.flipkart.service.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

// all operation related to the Admin
@Path("/admin")
public class AdminController {

    AdminService adminService = new AdminServiceImpl();

    // register admin
    @POST
    @Path("/register/{name}/{username}/{password}/{gender}")
    @Consumes("application/json")
    public Response registerAdmin(@PathParam("name") String adminName, @PathParam("username") String username,
                                    @PathParam("password") String password, @PathParam("gender") String gender)
    {
        Authenticate authenticate = new AuthenticateImpl();
        Admin admin = new Admin();
        admin.setName(adminName);
        admin.setUserName(username);
        admin.setGender(gender);
        authenticate.registerAdmin(admin, password);
        return Response.status(201).entity("User with username " + username + " is successfully registered").build();
    }

    // view courses
    @GET
    @Path("/viewCourses")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Course> viewCourses()
    {
        CourseService courseService = new CourseServiceImpl();
        return courseService.listCourses();
    }

    //view all the users
    @GET
    @Path("/viewUsers")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> viewUsers()
    {
        return adminService.viewUsers();
    }

    // assign a professor to the course
    @PUT
    @Path("/assignProfessor/{courseId}/{professorId}")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response assignProfessor(@PathParam("professorId") int professorId, @PathParam("courseId") int courseId)
    {
        Professor professor = new Professor();
        professor.setProfessorId(professorId);
        adminService.assignProfessor(professor, courseId);
        String result = "updated successfully";
        return Response.status(200).entity(result).build();
    }

    // add a course
    @POST
    @Path("/addCourse/{courseId}/{courseName}")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addCourse(@PathParam("courseId") int courseId, @PathParam("courseName") String courseName) {
        Course course = new Course();
        course.setCourseId(courseId);
        course.setCourseName(courseName);
        adminService.addCourse(course);
        return Response.status(201).entity("Added the course " + courseName + " Successfully").build();
    }

    // delete a course
    @DELETE
    @Path("/deleteCourse/{courseId}")
    public Response deleteCourse(@PathParam("courseId") int courseId) {
        Course course = new Course();
        course.setCourseId(courseId);
        adminService.deleteCourse(course);
        return Response.status(200).entity("Course " + " with course id " + courseId + " successfully deleted").build();
    }

    //approve a user
    @PUT
    @Path("/approveUser/{userId}")
    public Response approveUser(@PathParam("userId") int userId)
    {
        User user = new User();
        user.setId(userId);
        boolean approve = adminService.approveUser(user);
        return Response.status(200).entity("User with id " + userId + " is approved!").build();
    }

    // delete a user
    @DELETE
    @Path("/deleteUser/{userId}")
    public Response deleteUser(@PathParam("userId") int userId)
    {
        adminService.deleteUser(userId);
        return Response.status(200).entity("User with userId " + userId + "deleted successfully!").build();
    }
}
