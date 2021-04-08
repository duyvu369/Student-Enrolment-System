package Root;

import java.util.Date;

public class Student {
    private String sid;
    private String name;
    private Date birthdate;

    public Student(String sid, String name, Date birthdate) {
        this.sid = sid;
        this.name = name;
        this.birthdate = birthdate;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid='" + sid + '\'' +
                ", name='" + name + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }
}
