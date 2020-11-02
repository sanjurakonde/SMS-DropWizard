package com.flipkart.exception;

/**
 * The type Course not found exception.
 */
public class CourseNotFoundException extends Exception {
    public String toString()
    {
        return "Course not found!";
    }
}