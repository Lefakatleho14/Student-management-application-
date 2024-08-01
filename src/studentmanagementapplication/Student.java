package studentmanagementapplication;

import java.util.ArrayList;
import java.util.Scanner;
import static studentmanagementapplication.StudentManagementApplication.menuOptions;
import static studentmanagementapplication.StudentManagementApplication.welcomeMsg;

/**
*lefa motsoeneng
* St10449687
*/
public class Student {
//declare all my fields and array
    private String studentID;
    private String studentName;
    private int studentAge;
    private String studentEmail;
    private String studentCourse;
    public static ArrayList<Student> studentsArray = new ArrayList<>();

    public Student(String studentID, String studentName, int studentAge, String studentEmail, String studentCourse) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentAge = studentAge;
        this.studentEmail = studentEmail;
        this.studentCourse = studentCourse;
    }
//getters n setters
    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(int studentAge) {
        this.studentAge = studentAge;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getStudentCourse() {
        return studentCourse;
    }

    public void setStudentCourse(String studentCourse) {
        this.studentCourse = studentCourse;
    }

    public static ArrayList<Student> getStudentsArray() {
        return studentsArray;
    }

    public static void setStudentsArray(ArrayList<Student> studentsArray) {
        Student.studentsArray = studentsArray;
    }
//all my methods from the main are below
    public static void SaveStudent() {
        //method one !!!! mental at 100%
        Scanner hk = new Scanner(System.in);
        //formatting to look nice
        System.out.println("CAPTURE A NEW STUDENT ");
        System.out.println("***********************************");

        System.out.print("Enter the student id: ");
        String studentID = hk.nextLine();

        System.out.print("Enter the student name: ");
        String studentName = hk.nextLine();

        int studentAge = 0;
        boolean validAge = false;
        while (!validAge) {
            System.out.print("Enter the student age: ");
            String ageInput = hk.nextLine();
            //"\\d+" is a a way of checking that the age is a number and not a letter, the + is cause min age is 16 so we need to have many numbers
            if (ageInput.matches("\\d+")) {
                studentAge = Integer.parseInt(ageInput);

                if (studentAge >= 16) {
                    validAge = true;
                } else {
                    System.out.println("You have entered an incorrect age!!!");
                    System.out.print("Please re-enter the student age >> ");
                }//issues with getting it to prompt with System.out.print("Please re-enter the student age >> "); rather than System.out.print("Enter the student age: ");
            } else {
                System.out.println("You have entered an incorrect age!!!");
                System.out.print("Please re-enter the student age >> ");
            } //mental at 75%
        }

        System.out.print("Enter the student email: ");
        String studentEmail = hk.nextLine();

        System.out.print("Enter the student course: ");
        String studentCourse = hk.nextLine();

        // Create a new Student object and add it to the studentList
        Student student = new Student(studentID, studentName, studentAge, studentEmail, studentCourse);
        studentsArray.add(student);

        System.out.println("-----------------------------------------------");
        System.out.println("Student details have been successfully saved!");
        System.out.println("-----------------------------------------------");
        menuOptions();
        //method one done!!!!

    }//SaveStudent()

    public static void SearchStudent() {
        //method two !!!! mental at 100%
        Scanner hk = new Scanner(System.in);

        System.out.print("Enter the student id to search: ");
        String studentID = hk.nextLine();
        //boolean is for if id isnt found
        //mental at 50%

        System.out.println("------------------------------------------------");
        boolean found = false;
        for (Student student : studentsArray) {
            if (student.getStudentID().equals(studentID)) {
                // Print the student information if the ID is found
                System.out.println("STUDENT ID: " + student.getStudentID());
                System.out.println("STUDENT NAME: " + student.getStudentName());
                System.out.println("STUDENT AGE: " + student.getStudentAge());
                System.out.println("STUDENT EMAIL: " + student.getStudentEmail());
                System.out.println("STUDENT COURSE: " + student.getStudentCourse());

                found = true;// will stop from going to error message
                System.out.println("-----------------------------------------------------------");
                menuOptions(); // Return to the main menu options for flow of prog
                break;
            }
        }
        //i saw this message too many times
        if (!found) {
            System.out.println("Student with Student Id: " + studentID + " was not found!");
            System.out.println("-----------------------------------------------");
            menuOptions(); // //flow of prog
        }
    }//SearchStudent()

    public static void DeleteStudent() {
        //method three !!!! mental at 0%
        Scanner hk = new Scanner(System.in);

        //boolean is important here, need it for efficeincy and so prog runs well, it will end the lopp if student is found
        //and give a proper output if not
        boolean found = false;

        System.out.print("Enter the student id to delete: ");
        String studentID = hk.nextLine();

        //confirm output to help with user error
        System.out.println("Are you sure you want to student " + studentID + " from the system? Yes (y) to delete.");
        String stdDelete = hk.nextLine();
        System.out.println("---------------------------------------------------------------");

        // like an advanced for loop to run through stdInfo, using a var student that is of type StudentInfo, very sistifacted?? eng is hard
        for (Student student : studentsArray) {
            if (studentID.equals(student.getStudentID()) && stdDelete.equalsIgnoreCase("y")) {
                studentsArray.remove(student);
                System.out.println("Student with Student Id: " + student.getStudentID() + " was deleted!");
                System.out.println("---------------------------------------------------------------");
                found = true;
                welcomeMsg();
                break;
            }

        }
        if (!found) {
            System.out.println("Student with Student Id: " + studentID + " was not found.");
            System.out.println("---------------------------------------------------------------");
            menuOptions(); // also remove from inside loop to go through the array completetly not just the fisrt elemnt

        }
    }//DeleteStudent()

    public static void StudentReport() {
        //checks if there are any students in the first place
        if (!studentsArray.isEmpty()) {
            System.out.println("---------------------------------------------------------------");

            int i = 1;// to get the student 1 , student 2 ....
            for (Student student : studentsArray) {
                System.out.println("STUDENT " + i);
                System.out.println("---------------------------------------------------------------");
                System.out.println("STUDENT ID: " + student.getStudentID());
                System.out.println("STUDENT NAME: " + student.getStudentName());
                System.out.println("STUDENT AGE: " + student.getStudentAge());
                System.out.println("STUDENT EMAIL: " + student.getStudentEmail());
                System.out.println("STUDENT COURSE: " + student.getStudentCourse());
                System.out.println("---------------------------------------------------------------");
                i++;

            }
            welcomeMsg();
        } else {
            System.out.println("---------------------------------------------------------------");
            System.out.println("No students to report on.!");
            System.out.println("---------------------------------------------------------------");
            menuOptions();
        }
    }//StudentReport()

    public static void ExitStudentApplication() {
        System.out.println("Application exited succesfully!");//allow user to exit programme smoothly again, working
        System.exit(0);
    }// ExitStudentApplication()
}


