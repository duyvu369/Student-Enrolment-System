package Root;

import java.util.ArrayList;
import java.util.Date;

public interface StudentEnrolmentManager {
    public boolean add(Student student, Course course);
    public void update(String sid, String name, Date birthdate, Course course);
    public boolean delete();
    public void getOne();
    public void getAll();
}
