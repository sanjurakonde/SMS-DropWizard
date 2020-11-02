package com.flipkart.bean;

public class Student extends User {
    private int studentId;
    private String StudentName;
    private String address;
    private String contact;
    private boolean hasScholarship;
    private String gender;
    private int semester;
    private int isRegistered;

    /**
     * Gets student id.
     *
     * @return the student id
     */
    public int getStudentId() {
        return studentId;
    }

    /**
     * Sets student id.
     *
     * @param studentId the student id
     */
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    /**
     * Gets student name.
     *
     * @return the student name
     */
    public String getStudentName() {
        return StudentName;
    }

    /**
     * Sets student name.
     *
     * @param studentName the student name
     */
    public void setStudentName(String studentName) {
        this.StudentName = studentName;
    }

    /**
     * Gets address.
     *
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets address.
     *
     * @param address the address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets contact.
     *
     * @return the contact
     */
    public String getContact() {
        return contact;
    }

    /**
     * Sets contact.
     *
     * @param contact the contact
     */
    public void setContact(String contact) {
        this.contact = contact;
    }

    /**
     * Is has scholarship boolean.
     *
     * @return the boolean
     */
    public boolean isHasScholarship() {
        return hasScholarship;
    }

    /**
     * Sets has scholarship.
     *
     * @param hasScholarship the has scholarship
     */
    public void setHasScholarship(boolean hasScholarship) {
        this.hasScholarship = hasScholarship;
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

    /**
     * Gets semester.
     *
     * @return the semester
     */
    public int getSemester() {
        return semester;
    }

    /**
     * Sets semester.
     *
     * @param semester the semester
     */
    public void setSemester(int semester) {
        this.semester = semester;
    }

    /**
     * Gets is registered.
     *
     * @return the is registered
     */
    public int getIsRegistered() {
        return isRegistered;
    }

    /**
     * Sets is registered.
     *
     * @param isRegistered the is registered
     */
    public void setIsRegistered(int isRegistered) {
        this.isRegistered = isRegistered;
    }
}
