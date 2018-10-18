package studentdatabaseapp;

import java.sql.SQLOutput;
import java.util.Scanner;

public class StudentDatabaseApp {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        // Ask for number of students to be in the database
        System.out.println("Enter the number of Students: ");
        int numOfStudents = in.nextInt();

        // Create n number of new students
        Student[] students = new Student[numOfStudents];
        for(int i = 0;i<numOfStudents;i++){
            System.out.println();
            students[i] = new Student();
            students[i].enrollCourses();
            students[i].payTutionBalance();
            System.out.println(students[i].toString());
        }
    }
}
