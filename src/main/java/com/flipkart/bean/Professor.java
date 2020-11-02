package com.flipkart.bean;

public class Professor extends User {
    private int professorId;
    private String email;
    private String name;
    private String courseId;
    private String gender;

    /**
     * Gets course id.
     *
     * @return the course id
     */
    public String getCourseId() {
        return courseId;
    }

    /**
     * Sets course id.
     *
     * @param courseId the course id
     */
    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets professor id.
     *
     * @return the professor id
     */
    public int getProfessorId() {
        return professorId;
    }

    /**
     * Sets professor id.
     *
     * @param professorId the professor id
     */
    public void setProfessorId(int professorId) {
        this.professorId = professorId;
    }

    /**
     * Gets gender.
     *
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets gender.
     *
     * @param gender the gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }
}
