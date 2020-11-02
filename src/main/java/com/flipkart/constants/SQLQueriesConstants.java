package com.flipkart.constants;

public class SQLQueriesConstants {
    //Login query for a user
    public final static String LOGIN_QUERY = "SELECT r.role from Role r join  user u on r.roleId = u.roleId where username = ? and password = ?";
    public final static String GET_ROLE_ID_QUERY = "select roleId from role where role = ?";

    // View Courses
    public final static String VIEW_CATALOG_QUERY = "select courseId, courseName, fees, courseDescription from Course";
    public final static String VIEW_COURSE_QUERY = "select * from Course where courseId = ?";

    // Student Queries
    public final static String REGISTER_STUDENT_QUERY = "insert into Student(studentName, hasScholarship, gender, semester) values (?,?,?,?)";
    public final static String ADD_COURSE_STUDENT_QUERY = "insert into RegisteredCourses(studentId, courseId, courseType) values(?,?,?)";
    public final static String GET_REGISTERED_COURSES_QUERY = "select studentId, courseId, courseType from RegisteredCourses where studentId = ?";
    public final static String DROP_COURSE_STUDENT_QUERY = "delete from RegisteredCourses where courseId = ? and studentId = ?";
    public final static String COUNT_REGISTERED_COURSES_QUERY = "select count(*) from RegisteredCourses where studentId = ?";
    public final static String VIEW_GRADES_QUERY = "select c.courseId, c.courseName, rc.grade from Course c join RegisteredCourses rc on rc.courseId = c.courseId where rc.studentId = ?";
    public final static String CALCULATE_TOTAL_FEE = "select sum(c.fees) from RegisteredCourses rc join Course c on c.courseId = rc.courseId where rc.studentId = ?";
    public final static String MAKE_PAYMENT_QUERY = "insert into Payment(studentId, feesPaid, paymentMethodId) values(?, ?, ?)";
    public final static String UPDATE_AFTER_PAYMENT = "update Student set isRegistered = 1 where studentId = ?";
    public final static String CHECK_IF_REGISTERED_TO_COURSE_QUERY = "select count(*) from RegisteredCourses where studentId = ? and courseId = ?";
    public final static String GET_STUDENT_DETAILS_QUERY = "select studentId, studentName, hasScholarship, gender from Student where studentName = ?";

    // Professor Queries
    public final static String REGISTER_PROFESSOR_QUERY = "insert into Professor(professorName, gender) values (?,?)";
    public final static String GET_COURSE_TAUGHT_BY_PROFESSOR = "select p.courseId, c.courseName, c.courseDescription from ProfessorCourse p join Course c on c.courseId = p.courseId where p.professorId = ?";
    public final static String GET_STUDENTS_TAUGHT = "select rc.studentId, rc.courseId, s.studentName, s.gender, s.semester from Student s join RegisteredCourses rc on rc.studentId = s.studentId where rc.courseId in (select courseId from ProfessorCourse where professorId = ?) order by rc.courseId";
    public final static String GRADE_STUDENT_QUERY = "update RegisteredCourses set grade = ? where studentId = ? and courseId = ?";
    public final static String GET_PROFESSOR_DETAILS_QUERY = "select professorId, professorName, gender from Professor where professorName = ?";

    // Admin Queries
    public final static String REGISTER_ADMIN_QUERY = "insert into Admin(adminName, gender) values(?,?)";
    public final static String VIEW_USERS_QUERY = "SELECT  u.userId, u.username, r.role from user u join Role r on r.roleId = u.roleId;";
    public final static String ADD_NEW_COURSE_QUERY = "insert into Course(courseName, fees, courseDescription, catalogId) values (?, ?, ?, ?)";
    public final static String DELETE_COURSE_QUERY = "delete from Course where courseId = ?";
    public final static String REGISTER_USER_QUERY = "insert into user(username, password, roleId) values (?,?,?)";
    public final static String ASSIGN_PROFESSOR_QUERY = "insert into ProfessorCourse(courseId, professorId) values (?, ?)";
    public final static String DELETE_USER_QUERY = "delete from user where userId = ?";
    public final static String APPROVE_USER_QUERY = "update user set approved = 1 where userId = ?";
}
