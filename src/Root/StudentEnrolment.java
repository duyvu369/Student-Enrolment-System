package Root;

import java.util.ArrayList;
import java.util.List;

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

    public void showAllStudent(ArrayList<Student> allStudents) {
        System.out.println(allStudents);
    }

    public void showAllCourses(ArrayList<Course> allCourses) {
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

    public static void main(String[] args){
        Student student1 = new Student("s38329579","Nguyen Thi Hoa", "21/05/1995");
        Student student2 = new Student("s38474918","John Junior", "01/07/1996");
        Student student3 = new Student("s35459841","Dang Thi Anh", "03/09/1990");
        Student student4 = new Student("s39658754","Hoang Vu Minh Nhat", "22/2/1999");
        Student student5 = new Student("s32194028","Phan Van An", "01/01/1991");
        Student student6 = new Student("s32310900","Nguyen Tan Khoi", "22/03/1995");
        Student student7 = new Student("s35439081","Nguyen Anh Duy", "15/08/1994");
        Student student8 = new Student("s31243241","Robert Maggy", "11/03/2000");
        ArrayList<Student> allStudents = new ArrayList<Student>();
        allStudents.add(student1);
        allStudents.add(student2);
        allStudents.add(student3);
        allStudents.add(student4);
        allStudents.add(student5);
        allStudents.add(student6);
        allStudents.add(student7);
        allStudents.add(student8);

    }



}
