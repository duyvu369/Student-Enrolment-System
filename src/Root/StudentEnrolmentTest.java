package Root;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentEnrolmentTest {

    @Test
    void createEnrolment() {

        String[] data = {"S123123","Nguyen Thi Anh","21/03/2000","CPOS1234","Introduction to marketing","8","2021C"};

        StudentEnrolment newEnrolment = StudentEnrolment.createEnrolment(data);

        assertEquals("CPOS1234",newEnrolment.getCourse().getId());
        assertEquals("2021C",newEnrolment.getSemester());
        assertEquals("S123456",newEnrolment.getStudent().getSid());

    }
}