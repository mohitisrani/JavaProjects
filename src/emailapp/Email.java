package emailapp;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private int defaultPasswordLength = 10;
    private String department;
    private String company = "aeyCompany";
    private int mailBoxCapacity = 500;
    private String alternateEmail;

    // Constructor to receive first and last name
    public Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;

        // Call a method asking for department  -  return department
        this.department = setDepartment();

        // Combine elements to generate email
        this.email = this.firstName.toLowerCase()+"."+this.lastName.toLowerCase()+"@"+this.department+"."+this.company+".com";
        System.out.println("Your Email is: "+this.email);

        // Call a method to return a random password - return password
        this.password = randomPassword(this.defaultPasswordLength);
        System.out.println("Your Password is: "+this.password);

    }

    // Ask for the department
    private String setDepartment(){
        System.out.println("--Department Codes--\n1 for Sales\n2 for Development\n3 for Accounting\n0 for None\nEnter Department Code:\n");
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();
        switch(choice){
            case 1:
                return "sales";
            case 2:
                return "development";
            case 3:
                return "accounting";
            case 0:
                return "none";
            default:
                return setDepartment();
        }
    }

    // Generate a random password
    private String randomPassword(int length){
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$";
        char[] password = new char[length];
        for(int i = 0;i<password.length;i++){
            password[i] = chars.charAt((int)(Math.random()*chars.length()));
        }
        return new String(password);
    }

    // set mailBox Capacity

    public void setMailBoxCapacity(int mailBoxCapacity) {
        this.mailBoxCapacity = mailBoxCapacity;
    }

    // set an alternate email

    public void setAlternateEmail(String alternateEmail) {
        this.alternateEmail = alternateEmail;
    }

    // change the password
    public void changePassword(String password){
        this.password = password;
    }
    // Getter Methods
    public int getMailBoxCapacity() {
        return mailBoxCapacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public String getPassword() {
        return password;
    }

    public String showInfo(){
        return "Employee: "+firstName+" "+lastName+
                "\nDepartment: "+department+
                "\nMailbox Capacity: "+mailBoxCapacity;

    }
}
