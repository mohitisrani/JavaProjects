package studentdatabaseapp;

import java.util.Scanner;

public class Student {
    private String firstName;
    private String lastName;
    private int gradeYear;
    private String studentID;
    private String courses = "";
    private int tuitionBalance = 0;
    private static int costOfCourse = 600;
    private static int id = 0000;

    // Constructor: Prompt user to enter name and year;
    Student(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Student's First Name: ");
        this.firstName = in.next();

        System.out.println("Enter Student's Last Name: ");
        this.lastName = in.next();

        System.out.println("1 - Freshmen\n2 - Sophomore\n3 - Junior\n4 - Senior\nEnter Student Class Level:");
        this.gradeYear = in.nextInt();

        setStudentID();
    }

    // Generate 5 digit Unique ID
    private void setStudentID() {
        id++;
        this.studentID = String.format("%d%04d",this.gradeYear,id);
    }


    // Enroll in Courses
    public void enrollCourses(){
        Scanner in = new Scanner(System.in);
        String course;
        do {
            System.out.println("Enter course name to enroll(Q to quit)");
            course = in.next();
            if(!course.equals("Q")) {
                courses += "    "+course + "\n";
                this.tuitionBalance += this.costOfCourse;
            }else{
                break;
            }
        }while(true);
    }

    // View Balance
    public void viewTuitionBalance() {
        System.out.println("Your Balance Due is $"+this.tuitionBalance+"\n");
    }

    // Pay Tuition
    public void payTutionBalance(){
        viewTuitionBalance();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter payment value: $");
        int payment = in.nextInt();
        this.tuitionBalance -= payment;
        System.out.println("Thank you for your payment of $"+payment+".");
        viewTuitionBalance();
    }

    // Show info
    public String toString(){
        return ("Name: "+firstName+" "+lastName+
                "\nGrade level: "+gradeYear+
                "\nStudent ID: "+studentID+
                "\nCourses Enrolled: \n"+courses+
                "Balance Due: $"+tuitionBalance);
    }

}
