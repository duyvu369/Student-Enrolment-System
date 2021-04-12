package Root;

import java.util.ArrayList;
import java.util.Date;

public interface StudentEnrolmentManager {
    boolean add(Student student, Course course);
    void update(String sid, String name, String birthdate, Course course);
    boolean delete(Student student, Course course);

}
