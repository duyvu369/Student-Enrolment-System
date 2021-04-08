package Root;

import java.util.ArrayList;

public class Course {
    private String id;
    private String name;
    private int credit;
    private ArrayList<Student> studentList;

    public Course(String id, String name, int credit,ArrayList<Student> studentList) {
        this.id = id;
        this.name = name;
        this.credit = credit;
        this.studentList = studentList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", credit=" + credit +
                '}';
    }
}
