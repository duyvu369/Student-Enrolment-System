package Root;

public class StudentEnrolment {
    private Student student;
    private Course Course;
    private String semester;

    public StudentEnrolment(String semester) {
        this.semester = semester;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }
}
