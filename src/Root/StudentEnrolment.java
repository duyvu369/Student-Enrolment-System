package Root;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentEnrolment implements StudentEnrolmentManager {
    private Student student;
    private Course course;
    private String semester;
    private ArrayList<Course> courseList;

    public StudentEnrolment(String semester, ArrayList<Root.Course> courseList) {
        this.semester = semester;
        this.courseList = courseList;
    }

    public StudentEnrolment(String semester) {
        this.semester = semester;
    }

    public ArrayList<Root.Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(ArrayList<Root.Course> courseList) {
        this.courseList = courseList;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public boolean add(Student student, Course course) {
        if (course.getStudentList().contains(student)) {
            System.out.println("The student have already enrolled this course!");
            return false;
        } else {
            course.getStudentList().add(student);
            System.out.println("Successfully added a new student to the course.");
            return true;
        }
    }

    public void update(String sid, String name, String birthdate, Course course) {
        for (int i = 0; i < course.getStudentList().size(); i++) {
            if (course.getStudentList().get(i).getSid().equals(sid)) {
                course.getStudentList().get(i).setBirthdate(birthdate);
                course.getStudentList().get(i).setName(name);
                System.out.println("Successfully updated student personal information.!");
            }
        }
    }

    public boolean delete(Student student, Course course) {
        if (course.getStudentList().contains(student)) {
            System.out.println("The student does not exist in this course!");
            return false;
        } else {
            course.getStudentList().remove(student);
            System.out.println("Student deleted!");
            return true;
        }

    }
    public void showAllCourses(ArrayList<Course> allCourses) {
        System.out.println(semester);
        System.out.println(allCourses);
    }

    public void showStudentInfo(String sid, ArrayList<Student> allStudents) {
        for (int i = 0; i < allStudents.size(); i++) {
            if (allStudents.get(i).getSid().equals(sid)) {
                System.out.println("Student information: ");
                allStudents.get(i).toString();
            }
        }
    }
    public void showCourseInfo(String id, ArrayList<Course> allCourses){
        for (int i = 0; i < allCourses.size(); i++) {
            if (allCourses.get(i).getId().equals(id)) {
                System.out.println("Course information: ");
                allCourses.get(i).toString();
            }
        }
    }
    public static void  mainMenu(){
        System.out.println("Main Menu");
        System.out.println("1.Show all courses in a semester");
        System.out.println("2.Show a course info");
        System.out.println("3.Show a student info");
        System.out.println("4.Enrol a student");
        System.out.println("5.Remove a student");
    }
    public static void showAllCourseInfo(StudentEnrolment sem){
        System.out.println("Semester " + sem.getSemester());
        for (int i=0;i<sem.getCourseList().size();i++){
            System.out.println(sem.getCourseList().get(i).toString());
        }
    }
    public static void showAllSemesterInfo(StudentEnrolment sem1,StudentEnrolment sem2,StudentEnrolment sem3){
        Scanner input1 = new Scanner(System.in);
        System.out.println("There are a total of 3 semesters, if you wish to see courses in all semester type 4! ");
        System.out.print("Please enter the semester number: ");
        int option = input1.nextInt();
        if (option==1){
            showAllCourseInfo(sem1);
        } else if (option == 2){
            showAllCourseInfo(sem2);
        } else if (option == 3){
            showAllCourseInfo(sem3);
        } else if (option == 4){
            showAllCourseInfo(sem1);
            showAllCourseInfo(sem2);
            showAllCourseInfo(sem3);
        } else {
            System.out.println("Invalid input, going back to main menu!");
            mainMenu();
        }

    }

    public static void main(String[] args){

        //Create new students
        Student student1 = new Student("s38329579","Nguyen Thi Hoa", "21/05/1995");
        Student student2 = new Student("s38474918","John Junior", "01/07/1996");
        Student student3 = new Student("s35459841","Dang Thi Anh", "03/09/1990");
        Student student4 = new Student("s39658754","Hoang Vu Minh Nhat", "22/2/1999");
        Student student5 = new Student("s32194028","Phan Van An", "01/01/1991");
        Student student6 = new Student("s32310900","Nguyen Tan Khoi", "22/03/1995");
        Student student7 = new Student("s35439081","Nguyen Anh Duy", "15/08/1994");
        Student student8 = new Student("s31243241","Robert Maggy", "11/03/2000");


        ArrayList<Student> allStudents = new ArrayList<Student>();

        //Add all the student info into a student arrayList
        allStudents.add(student1);allStudents.add(student2);allStudents.add(student3);allStudents.add(student4);
        allStudents.add(student5);allStudents.add(student6);allStudents.add(student7);allStudents.add(student8);

        //Create new courses
        Course course1 = new Course("O2SNDS5","Introduction to Information Technology",12);
        Course course2 = new Course("12543MS","Introduction to International Business",12);
        Course course3 = new Course("9DSANJO","Software Engineering Project Management",12);
        Course course4 = new Course("45SHJAH","Vietnamese 1",12);
        Course course5 = new Course("45XNFHS","Digital Marketing",12);
        Course course6 = new Course("12ZXMND","Dipomatic",12);

        ArrayList<Course> allCourses1 = new ArrayList<Course>();
        ArrayList<Course> allCourses2 = new ArrayList<Course>();
        ArrayList<Course> allCourses3 = new ArrayList<Course>();

        //Add all the courses to the approritate semester

        allCourses1.add(course1);allCourses1.add(course2);
        StudentEnrolment sem1 = new StudentEnrolment("1",allCourses1);

        allCourses2.add(course3);allCourses2.add(course4);
        StudentEnrolment sem2 = new StudentEnrolment("2",allCourses2);

        allCourses3.add(course5);allCourses3.add(course6);
        StudentEnrolment sem3 = new StudentEnrolment("3",allCourses3);


        //Console App interface
        mainMenu();
       Scanner user = new Scanner(System.in);
            System.out.print("Please choose an option: ");
            int option = user.nextInt();
            if (option==1){
                showAllSemesterInfo(sem1,sem2,sem3);
            }




    }



}
