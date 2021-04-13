package Root;

import java.util.ArrayList;
import java.util.Date;

public class Student {
    private String sid;
    private String name;
    private String birthdate;
    public Student(String sid, String name, String birthdate) {
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

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return "sId: " + sid +"\n"+
                "Full Name: " + name +"\n"+
                "Birthdate: " + birthdate;
    }
}
