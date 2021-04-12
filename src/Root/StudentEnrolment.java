package Root;

import java.util.ArrayList;
import java.util.Date;

public class StudentEnrolment implements StudentEnrolmentManager{
    private Student student;
    private Course Course;
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

    public boolean add(Student student, Course course){
        if(course.getStudentList().contains(student))
        {
            System.out.println("The student have already enrolled this course!");
            return false;
        } else {
            course.getStudentList().add(student);
            System.out.println("Successfully added a new student to the course.");
            return true;
        }
    }

    public void update(String sid, String name, Date birthdate,Course course){
        for (int i = 0;i<course.getStudentList().size();i++){
            if (course.getStudentList().get(i).getSid().equals(sid)){
                course.getStudentList().get(i).setBirthdate(birthdate);
                course.getStudentList().get(i).setName(name);
                System.out.println("Successfully updated student personal information.!");
            }
        }
    }

    public boolean delete(Student student,Course course){
        if(course.getStudentList().contains(student))
        {
            System.out.println("The student does not exist in this course!");
            return false;
        } else {
            course.getStudentList().remove(student);
            System.out.println("Student deleted!");
            return true;
        }

    }
    public void getAll(){
        System.out.println(course);
    }
    public void getOne(Course course){
        System.out.println(course);
    }


}
