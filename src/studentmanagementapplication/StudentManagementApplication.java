package studentmanagementapplication;

import java.util.ArrayList;
import java.util.Scanner;

/**
* lefa motsoeneng
* ST10449687
*/
public class StudentManagementApplication {
    private static ArrayList<Student> studentsArray = new ArrayList<>();

    public static void main(String[] args) {
        welcomeMsg();//keeps main looking clean and simple
    }

    public static void welcomeMsg() {
        //header displayed when prog is run
        System.out.println("STUDENT MANAGEMENT APPLICATION");
        System.out.println("=======================================");
        System.out.println("ENTER (1) to launch menu or any other key to exit");

        Scanner hk = new Scanner(System.in);//scanner to read user input

        String input = hk.nextLine();
        // anything other than 1 will close the app
        if (input.equals("1")) {
            menuOptions();
        } else {
            System.out.println("Application Exited!");
            System.exit(0);
        }
    }//welcomeMsg()

    public static void menuOptions() {
        //all menu options if 1 is selected
        System.out.println("Please select one of the following menu items:");
        System.out.println("(1) Capture a new student.");
        System.out.println("(2) Search for a student.");
        System.out.println("(3) Delete a student.");
        System.out.println("(4) Print student report.");
        System.out.println("(5) Exit Application.");

        Scanner hk = new Scanner(System.in);
        int input = hk.nextInt();

        //switch to lead to different methods deopending on user input
        switch (input) {
            case 1:
                SaveStudent();//allow user to add a student to the system, working
                break;
            case 2:
                SearchStudent();//allow user to search for a student, working
                break;
            case 3:
                DeleteStudent();//allow user to thanos snap a student, working on it rn
            case 4:
                StudentReport();//allow user to see all students and their info, done
            case 5:
                ExitStudentApplication();//the ability for the user to exit the application, ah to easy
                break;
            default:
                System.exit(0);//added for user error, leads to smooth exit rather than a proigramme crash, i hope
                break;

        }
    }//menuOptions()

    public static void SaveStudent() {
        //method one !!!! mental at 100%
        Scanner hk = new Scanner(System.in);
        //formatting to look nice
        System.out.println("CAPTURE A NEW STUDENT ");
        System.out.println("=========================================");

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

        System.out.println("###############################################");
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
            System.out.println("No students to report on. ");
            System.out.println("---------------------------------------------------------------");
            menuOptions();
        }
    }//StudentReport()

    public static void ExitStudentApplication() {
        System.out.println("Application exited succesfully!");//allow user to exit programme smoothly again, working
        System.exit(0);
    }// ExitStudentApplication()
}



