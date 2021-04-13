package Root;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class StudentEnrolment {
    private Student student;
    private Course course;
    private String semester;


    public StudentEnrolment(String semester, Student student, Course course) {
        this.semester = semester;
        this.student = student;
        this.course = course;
    }

    @Override
    public String toString() {
        return
                "Student id: " + student.getSid() +
                        " Course id: " + course.getId() +
                        " Semester: " + semester;
    }

    public StudentEnrolment(String semester) {
        this.semester = semester;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public static void enrol(ArrayList<Student> allStudents, ArrayList<Course> allCourses, List<StudentEnrolment> enrolmentList) {
        Student selectedStudent = new Student("", "", "");
        Course selectedCourse = new Course("", "", 0);
        System.out.println("Enter the student ID: ");
        Scanner input4a = new Scanner(System.in);
        String option4a = input4a.next();
        ArrayList<String> studentSID = new ArrayList<String>();
        for (Student student : allStudents) {
            studentSID.add(student.getSid());
        }

        if (studentSID.contains(option4a)) {
            for (Student student : allStudents) {
                if (student.getSid().equals(option4a)) {
                    selectedStudent = student;
                }
            }
        } else {
            System.out.println("The student does not exist in the school!");
            exit(allStudents, allCourses, enrolmentList);
        }
        System.out.print("Please Enter semester ");
        Scanner input4b = new Scanner(System.in);
        String option4b = input4b.next();
        System.out.print("Please Enter the course ID: ");
        Scanner input4c = new Scanner(System.in);
        String option4c = input4c.next();
        ArrayList<String> courseID = new ArrayList<String>();
        for (Course course : allCourses) {
            courseID.add(course.getId());
        }
        if (courseID.contains(option4c)) {
            for (Course course : allCourses) {
                if (course.getId().equals(option4c)) {
                    selectedCourse = course;
                }
            }
        } else {
            System.out.println("Invalid course ID!");
            exit(allStudents, allCourses, enrolmentList);
        }
        enrolmentList.add(new StudentEnrolment(option4b, selectedStudent, selectedCourse));
        System.out.println("Successfully enrolled student " + selectedStudent.getSid() + " to Course" + selectedCourse.getId() + " " + selectedCourse.getName());
        exit(allStudents, allCourses, enrolmentList);
    }

    public static void delete(ArrayList<Student> allStudents, ArrayList<Course> allCourses, List<StudentEnrolment> enrolmentList) {
        Student selectedStudent = new Student("", "", "");
        Course selectedCourse = new Course("", "", 0);
        System.out.println("Enter the student ID: ");
        Scanner input4a = new Scanner(System.in);
        String option4a = input4a.next();
        ArrayList<String> studentSID = new ArrayList<String>();
        for (Student student : allStudents) {
            studentSID.add(student.getSid());
        }

        if (studentSID.contains(option4a)) {
            for (Student student : allStudents) {
                if (student.getSid().equals(option4a)) {
                    selectedStudent = student;
                }
            }
        } else {
            System.out.println("The student does not exist in the school!");
            exit(allStudents, allCourses, enrolmentList);
        }
        System.out.print("Please Enter semester: ");
        Scanner input4b = new Scanner(System.in);
        String option4b = input4b.next();
        System.out.print("Please Enter the course ID: ");
        Scanner input4c = new Scanner(System.in);
        String option4c = input4c.next();
        ArrayList<String> courseID = new ArrayList<String>();
        for (Course course : allCourses) {
            courseID.add(course.getId());
        }
        if (courseID.contains(option4c)) {
            for (Course course : allCourses) {
                if (course.getId().equals(option4c)) {
                    selectedCourse = course;
                }
            }
        } else {
            System.out.println("Invalid course ID!");
            exit(allStudents, allCourses, enrolmentList);
        }
        enrolmentList.remove(new StudentEnrolment(option4b, selectedStudent, selectedCourse));
        System.out.println("Successfully cancel the enrolment of student " + selectedStudent.getSid() + " to Course" + selectedCourse.getId() + " " + selectedCourse.getName());
        exit(allStudents, allCourses, enrolmentList);
    }


    public static void showAllCourses(ArrayList<Student> allStudents, ArrayList<Course> allCourses, List<StudentEnrolment> enrolmentList) {
        System.out.println(allCourses);
        exit(allStudents, allCourses, enrolmentList);
    }

    public static void showAllStudents(ArrayList<Student> allStudents, ArrayList<Course> allCourses, List<StudentEnrolment> enrolmentList) {
        System.out.println(allStudents);
        exit(allStudents, allCourses, enrolmentList);
    }

    public static void showStudentInfo(ArrayList<Student> allStudents, ArrayList<Course> allCourses, List<StudentEnrolment> enrolmentList) {
        Scanner input3 = new Scanner(System.in);
        System.out.println("Please enter the student sId :");
        String option3 = input3.next();
        for (Student student : allStudents) {
            if (student.getSid().equals(option3)) {
                System.out.println("Student information: ");
                System.out.println(student);
            }
        }
        System.out.println("Course Enrolled: ");
        for (StudentEnrolment enrolment : enrolmentList) {
            if (enrolment.getStudent().getSid().equals(option3)) {
                System.out.println("ID: " + enrolment.getCourse().getId() + " - " + enrolment.getCourse().getName());
            }
        }
        exit(allStudents, allCourses, enrolmentList);

    }

    public static void showCourseInfo(ArrayList<Student> allStudents, ArrayList<Course> allCourses, List<StudentEnrolment> enrolmentList) {
        System.out.println("Enter the course ID: ");
        Scanner input2 = new Scanner(System.in);
        String option2 = input2.next();
        int k = 0;
        for (StudentEnrolment enrolment : enrolmentList) {
            if (enrolment.getCourse().getId().equals(option2)) {
                k++;
                System.out.println("sId: " + enrolment.getStudent().getSid() + " Name: " + enrolment.getStudent().getName());
            }
        }
        if (k == 0) {
            System.out.println("There is no students in that course!");
        }
        exit(allStudents, allCourses, enrolmentList);
    }

    public static boolean exit(ArrayList<Student> allStudents, ArrayList<Course> allCourses, List<StudentEnrolment> enrolmentList) {
        System.out.println("Do you want to exit the program? (y/n)");
        Scanner next = new Scanner(System.in);
        String action = next.next();
        if (action.toLowerCase().equals("n") || action.toLowerCase().equals("no")) {
            mainMenu(allStudents, allCourses, enrolmentList);
        } else if (action.toLowerCase().equals("y") || action.toLowerCase().equals("yes")) {
            System.out.println("System exited");
        } else {
            System.out.println("Invalid input!");
            exit(allStudents, allCourses, enrolmentList);
        }
        return true;
    }



    public static void mainMenu(ArrayList<Student> allStudents,ArrayList<Course> allCourses, List<StudentEnrolment> enrolmentList) {
        System.out.println("Main Menu");
        System.out.println("1.Show all courses in a semester");
        System.out.println("2.Show all students in a course");
        System.out.println("3.Show a student info");
        System.out.println("4.Enrol a student");
        System.out.println("5.Cancel an enrolment");
        Scanner user = new Scanner(System.in);
        System.out.print("Please choose an option: ");
        int option = user.nextInt();
        if (option == 1) {
            showSemesterInfo(allStudents,allCourses,enrolmentList);
        }
        else if (option == 2) {
            showCourseInfo(allStudents,allCourses,enrolmentList);
        }
        else if (option == 3) {
            showStudentInfo(allStudents,allCourses, enrolmentList);
        }
        else if (option == 4) {
            enrol(allStudents,allCourses,enrolmentList);
        }
        else if (option ==5){
            delete(allStudents,allCourses,enrolmentList);
        }
    }


    public static void showSemesterInfo(ArrayList<Student> allStudents, ArrayList<Course> allCourses, List<StudentEnrolment> enrolmentList) {
        Scanner input1 = new Scanner(System.in);
        System.out.print("Please enter the semester :");
        String option = input1.next();
        int k = 0;
        for (StudentEnrolment enrolment : enrolmentList) {
            if (enrolment.getSemester().equals(option)) {
                k++;
                System.out.println("Course id: " + enrolment.getCourse().getId() + " Course Name: " + enrolment.getCourse().getName());
            }
        }
        if (k == 0) {
            System.out.println("There is no courses in that semester!");
        }
        exit(allStudents, allCourses, enrolmentList);
    }


    public static void main(String[] args) {

        //Create new students
        Student student1 = new Student("s3832957", "Nguyen Thi Hoa", "21/05/1995");
        Student student2 = new Student("s3847491", "John Junior", "01/07/1996");
        Student student3 = new Student("s3545984", "Dang Thi Anh", "03/09/1990");
        Student student4 = new Student("s3965875", "Hoang Vu Minh Nhat", "22/2/1999");
        Student student5 = new Student("s3219402", "Phan Van An", "01/01/1991");
        Student student6 = new Student("s3231090", "Nguyen Tan Khoi", "22/03/1995");
        Student student7 = new Student("s3543908", "Nguyen Anh Duy", "15/08/1994");
        Student student8 = new Student("s3124324", "Robert Maggy", "11/03/2000");


        ArrayList<Student> allStudents = new ArrayList<Student>();

        //Add all the student info into the database
        allStudents.add(student1);
        allStudents.add(student2);
        allStudents.add(student3);
        allStudents.add(student4);
        allStudents.add(student5);
        allStudents.add(student6);
        allStudents.add(student7);
        allStudents.add(student8);

        //Create new courses
        Course course1 = new Course("O2SNDS5", "Introduction to Information Technology", 12);
        Course course2 = new Course("12543MS", "Introduction to International Business", 12);
        Course course3 = new Course("9DSANJO", "Software Engineering Project Management", 12);
        Course course4 = new Course("45SHJAH", "Vietnamese 1", 12);
        Course course5 = new Course("45XNFHS", "Digital Marketing", 12);
        Course course6 = new Course("12ZXMND", "Dipomatic", 12);

        //Add all the courses to the approritate semester

        ArrayList<Course> allCourses = new ArrayList<Course>();

        allCourses.add(course1);
        allCourses.add(course2);
        allCourses.add(course3);
        allCourses.add(course4);
        allCourses.add(course5);
        allCourses.add(course6);

        List<StudentEnrolment> enrolmentRecord = new ArrayList<StudentEnrolment>();


        enrolmentRecord.add(new StudentEnrolment("2018A",student4,course3));
        enrolmentRecord.add(new StudentEnrolment("2021C", student1, course4));
        enrolmentRecord.add(new StudentEnrolment("2021A", student3, course2));
        enrolmentRecord.add(new StudentEnrolment("2021B", student6, course1));
        enrolmentRecord.add(new StudentEnrolment("2021C", student2, course4));
        enrolmentRecord.add(new StudentEnrolment("2020C", student3, course1));
        enrolmentRecord.add(new StudentEnrolment("2021A", student4, course6));
        enrolmentRecord.add(new StudentEnrolment("2020A", student7, course3));
        enrolmentRecord.add(new StudentEnrolment("2021B", student8, course5));

        //Console App interface
        mainMenu(allStudents,allCourses,enrolmentRecord);


    }
}




