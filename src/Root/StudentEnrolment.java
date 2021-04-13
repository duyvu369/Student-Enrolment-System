package Root;

import org.junit.jupiter.params.shadow.com.univocity.parsers.csv.CsvWriter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentEnrolment {
    private Student student;
    private Course course;
    private String semester;


    public StudentEnrolment(String semester, Student student, Course course) {
        this.semester = semester;
        this.student = student;
        this.course = course;
    }

    @Override
    public String toString() {
        return
                "Student id: " + student.getSid() +
                        " Course id: " + course.getId() +
                        " Semester: " + semester;
    }

    public StudentEnrolment(String semester) {
        this.semester = semester;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }
    //Create a StudentEnrolment list using a csv file
    protected static StudentEnrolment createEnrolment(String[] fileInput){
        String sid = fileInput[0];
        String name = fileInput[1];
        String birthday = fileInput[2];
        Student student = new Student(sid,name,birthday);
        String id = fileInput[3];
        String courseName = fileInput[4];
        int credit = Integer.parseInt(fileInput[5]);
        Course course = new Course(id,courseName,credit);
        String semester = fileInput[6];
        return new StudentEnrolment(semester,student,course);
    }
    //Enrol a student into a course
    protected static void enrol(List<StudentEnrolment> enrolmentList) {
        Student selectedStudent = new Student("", "", "");
        Course selectedCourse = new Course("", "", 0);
        //Ask user for student ID
        System.out.println("Enter the student ID: ");
        Scanner input4a = new Scanner(System.in);
        String option4a = input4a.next();

        //Check if the student ID exists

        ArrayList<String> studentSID = new ArrayList<String>();
        for (StudentEnrolment enrolment : enrolmentList) {
            studentSID.add(enrolment.getStudent().getSid());
        }
        if (studentSID.contains(option4a)) {
            for (StudentEnrolment enrolment: enrolmentList) {
                if (enrolment.getStudent().getSid().equals(option4a)) {
                    selectedStudent = enrolment.getStudent();
                }
            }
        } else {
            System.out.println("The student does not exist in the school!");
            exit( enrolmentList);
        }
        //Ask the user for the semester info
        System.out.print("Please Enter semester: ");
        Scanner input4b = new Scanner(System.in);
        String option4b = input4b.next();

        //Ask the user to input the course ID
        System.out.print("Please Enter the course ID: ");
        Scanner input4c = new Scanner(System.in);
        String option4c = input4c.next();

        //Check if that course ID exist
        ArrayList<String> courseID = new ArrayList<String>();
        for (StudentEnrolment enrolment : enrolmentList) {
            courseID.add(enrolment.getCourse().getId());
        }
        if (courseID.contains(option4c)) {
            for (StudentEnrolment enrolment : enrolmentList) {
                if (enrolment.getCourse().getId().equals(option4c)) {
                    selectedCourse = enrolment.getCourse();
                }
            }
        } else {
            System.out.println("Invalid course ID!");
            exit(enrolmentList);
        }
        //add the new enrolment to the database
        enrolmentList.add(new StudentEnrolment(option4b, selectedStudent, selectedCourse));
        //dis a message
        System.out.println("Successfully enrolled student " + selectedStudent.getSid() + " to " + selectedCourse.getId() + " " + selectedCourse.getName());

        try {
            //Write the enrolment into the csv file
            FileWriter csvWriter = new FileWriter("default.csv",true);
            BufferedWriter bufferedWriter = new BufferedWriter(csvWriter);
            bufferedWriter.write(selectedStudent.getSid()+',');
            bufferedWriter.write(selectedStudent.getName()+',');
            bufferedWriter.write(selectedStudent.getBirthdate()+',');
            bufferedWriter.write(selectedCourse.getId()+',');
            bufferedWriter.write(selectedCourse.getName()+',');
            bufferedWriter.write(String.valueOf(selectedCourse.getCredit())+',');
            bufferedWriter.write(option4b+'\n');
            bufferedWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        //Ask if user want to go back to main menu
        exit(enrolmentList);
    }

    protected static void delete( List<StudentEnrolment> enrolmentList) {
        //same as enrol a student
        Student selectedStudent = new Student("", "", "");
        Course selectedCourse = new Course("", "", 0);
        System.out.println("Enter the student ID: ");
        Scanner input4a = new Scanner(System.in);
        String option4a = input4a.next();
        ArrayList<String> studentSID = new ArrayList<String>();
        for (StudentEnrolment enrolment : enrolmentList) {
            studentSID.add(enrolment.getStudent().getSid());
        }

        if (studentSID.contains(option4a)) {
            for (StudentEnrolment enrolment: enrolmentList) {
                if (enrolment.getStudent().getSid().equals(option4a)) {
                    selectedStudent = enrolment.getStudent();
                }
            }
        } else {
            System.out.println("The student does not exist in the school!");
            exit( enrolmentList);
        }
        System.out.print("Please Enter semester: ");
        Scanner input4b = new Scanner(System.in);
        String option4b = input4b.next();
        System.out.print("Please Enter the course ID: ");
        Scanner input4c = new Scanner(System.in);
        String option4c = input4c.next();
        ArrayList<String> courseID = new ArrayList<String>();
        for (StudentEnrolment enrolment : enrolmentList) {
            courseID.add(enrolment.getCourse().getId());
        }
        if (courseID.contains(option4c)) {
            for (StudentEnrolment enrolment : enrolmentList) {
                if (enrolment.getCourse().getId().equals(option4c)) {
                    selectedCourse = enrolment.getCourse();
                }
            }
        } else {
            System.out.println("Invalid course ID!");
            exit( enrolmentList);
        }
        enrolmentList.remove(new StudentEnrolment(option4b, selectedStudent, selectedCourse));
        System.out.println("Successfully cancel the enrolment of student " + selectedStudent.getSid() + " to Course" + selectedCourse.getId() + " " + selectedCourse.getName());
        exit( enrolmentList);
    }


    protected static void showStudentInfo(List<StudentEnrolment> enrolmentList){
        try {
            //Write the result to a csv file
            FileWriter csvWriter = new FileWriter("student_info.csv");
            BufferedWriter bufferedWriter = new BufferedWriter(csvWriter);

            Scanner input3 = new Scanner(System.in);
            System.out.println("Please enter the student sId :");
            String option3 = input3.next();

            for (StudentEnrolment enrolment : enrolmentList) {
                if (enrolment.getStudent().getSid().equals(option3)) {
                    System.out.println("Student information: ");
                    System.out.println(enrolment.getStudent());
                    bufferedWriter.write(enrolment.getStudent().getSid()+',');
                    bufferedWriter.write(enrolment.getStudent().getName()+',');
                    bufferedWriter.write(enrolment.getStudent().getBirthdate()+',');
                }
            }

            System.out.println("Course Enrolled: ");
            for (StudentEnrolment enrolment : enrolmentList) {
                if (enrolment.getStudent().getSid().equals(option3)) {
                    bufferedWriter.write(enrolment.getCourse().getId()+',');
                    bufferedWriter.write(enrolment.getCourse().getName()+',');
                    bufferedWriter.write(String.valueOf(enrolment.getCourse().getCredit()));
                    System.out.println("ID: " + enrolment.getCourse().getId() + " - " + enrolment.getCourse().getName());
                }
            }
                bufferedWriter.write('\n');
                bufferedWriter.close();
                exit(enrolmentList);
            }catch (IOException e){
                e.printStackTrace();

        }
    }

    protected static void showCourseInfo(List<StudentEnrolment> enrolmentList) {
        try {
            //write the result to a csv file
            FileWriter csvWriter = new FileWriter("course_info.csv");
            BufferedWriter bufferedWriter = new BufferedWriter(csvWriter);
            //Ask user to type the Course ID
            System.out.println("Enter the course ID: ");
            Scanner input2 = new Scanner(System.in);
            String option2 = input2.next();
            int k = 0;
            for (StudentEnrolment enrolment : enrolmentList) {
                if (enrolment.getCourse().getId().equals(option2)) {
                    k++;
                    System.out.println("sId: " + enrolment.getStudent().getSid() + " Name: " + enrolment.getStudent().getName());
                    bufferedWriter.write(enrolment.getStudent().getSid()+',');
                    bufferedWriter.write(enrolment.getStudent().getName()+',');
                    bufferedWriter.write(enrolment.getStudent().getBirthdate());
                    bufferedWriter.write('\n');
                }
            }
            bufferedWriter.flush();
            bufferedWriter.close();
            if (k == 0) {
                System.out.println("There is no students in that course!");
            }
            exit(enrolmentList);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    protected static void showSemesterInfo(List<StudentEnrolment> enrolmentList) {
        //Write the result to a csv file
        try {FileWriter csvWriter = new FileWriter("semester_info.csv");
            BufferedWriter bufferedWriter = new BufferedWriter(csvWriter);

        Scanner input1 = new Scanner(System.in);
        System.out.print("Please enter the semester :");
        String option = input1.next();
        int k = 0;
        for (StudentEnrolment enrolment : enrolmentList) {
            if (enrolment.getSemester().equals(option)) {
                k++;
                System.out.println("Course id: " + enrolment.getCourse().getId() + " Course Name: " + enrolment.getCourse().getName());
                bufferedWriter.write(enrolment.getCourse().getId()+',');
                bufferedWriter.write(enrolment.getCourse().getName()+',');
                bufferedWriter.write(String.valueOf(enrolment.getCourse().getCredit())+',');
                bufferedWriter.write(option);
                bufferedWriter.write('\n');

            }
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        if (k == 0) {
            System.out.println("There is no courses in that semester!");
        }
        exit( enrolmentList);}
        catch (IOException e){
            e.printStackTrace();
        }
    }
    protected static void showEnrolmentHistory(List<StudentEnrolment> studentEnrolmentList){
        for(StudentEnrolment enrolment:studentEnrolmentList){
            System.out.println(enrolment);
            exit(studentEnrolmentList);
        }
    }
    //After choosing an option, user can exit or go back to main menu
    protected static void exit(List<StudentEnrolment> enrolmentList) {
        System.out.println("Do you want to exit the program? (y/n)");
        Scanner next = new Scanner(System.in);
        String action = next.next();
        if (action.toLowerCase().equals("n") || action.toLowerCase().equals("no")) {
            mainMenu( enrolmentList);
        } else if (action.toLowerCase().equals("y") || action.toLowerCase().equals("yes")) {
            System.out.println("System exited");
        } else {
            System.out.println("Invalid input!");
            exit(enrolmentList);
        }
    }

    //Program interface and functions
    protected static void mainMenu(List<StudentEnrolment> enrolmentList) {
        System.out.println("Main Menu");
        System.out.println("1.Show all courses in a semester");
        System.out.println("2.Show all students in a course");
        System.out.println("3.Show a student info");
        System.out.println("4.Enrol a student");
        System.out.println("5.Cancel an enrolment");
        System.out.println("6.Show enrolment history");
        Scanner user = new Scanner(System.in);
        System.out.print("Please choose an option: ");
        int option = user.nextInt();
        if (option == 1) {
            showSemesterInfo(enrolmentList);
        }
        else if (option == 2) {
            showCourseInfo(enrolmentList);
        }
        else if (option == 3) {
            showStudentInfo(enrolmentList);
        }
        else if (option == 4) {
            enrol(enrolmentList);
        }
        else if (option ==5){
            delete(enrolmentList);
        }
        else if (option ==6){
            showEnrolmentHistory(enrolmentList);
        } else {
            exit(enrolmentList);
        }
    }

    //read csv file and generate StudentEnrolment list
    private static List<StudentEnrolment> readBooksFromCSV(String fileName)
    { List<StudentEnrolment> enrolmentRecords = new ArrayList<>();
    Path pathToFile = Paths.get(fileName);
        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII))
        {
            String line = br.readLine();
            while (line != null) {
                String[] attributes = line.split(",");
                StudentEnrolment enrolmentRecord = createEnrolment(attributes);
                enrolmentRecords.add(enrolmentRecord);
                line = br.readLine(); } }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return enrolmentRecords;
    }

    public static void main(String[] args) {

        //Start console App
        System.out.println("Do you want to import an CSV file? type n or no if you don't want to!");
        Scanner user = new Scanner(System.in);
        String answer = user.next();
        if (answer.toLowerCase().equals("n")||answer.toLowerCase().equals("no")){
            List<StudentEnrolment> studentEnrolmentList = readBooksFromCSV("C:\\Users\\ADMIN\\Desktop\\SES\\Student-Enrolment-System\\default.csv");
            mainMenu(studentEnrolmentList);
        } else{
            System.out.println("Type in the file name: ");
            Scanner file = new Scanner(System.in);
            String csv = file.next();
            List<StudentEnrolment> studentEnrolmentList = readBooksFromCSV(csv);
            mainMenu(studentEnrolmentList);
        }
    }
}




