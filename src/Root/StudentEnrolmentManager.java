package Root;

import java.util.ArrayList;
import java.util.Date;

public interface StudentEnrolmentManager {
    public void add(Student student, Course course);
    public void update(String sid, String name, Date birthdate, Course course);
    public void delete();
    public void getOne();
    public void getAll();
}
