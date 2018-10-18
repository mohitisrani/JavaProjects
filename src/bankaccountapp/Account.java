package bankaccountapp;

public abstract class Account implements IRate{
    // List common properties for savings and checking accounts
    private String name;
    private String sSN;
    private double balance;

    private static int number = 0;
    protected String accountNumber;
    protected double rate;

    // Constructor to set base properties and initialize the account
    public Account(String name, String sSN, double initDeposit){
        this.name = name;
        this.sSN = sSN;
        balance = initDeposit;

        //Set account number
        accountNumber = setAccountNumber();
        setRate();

    }

    private String setAccountNumber(){
        String lastTwoOfSSN = sSN.substring(sSN.length()-2);
        String unique5 = String.format("%05d",number++);
        String random3 = String.format("%03d",(int)(Math.random()*Math.pow(10,3)));
        return lastTwoOfSSN + unique5 + random3;
    }

    public abstract void setRate();

    public void compound(){
        double accruedInterest = balance*(rate/100);
        balance += accruedInterest;
        System.out.println("Accrued Interest: $"+accruedInterest);
        printBalance();
    }

    // List common methods

    public void deposit(double amount){
        balance += amount;
        System.out.println("Depositing $"+amount);
        printBalance();
    }
    public void withdraw(double amount){
        balance -= amount;
        System.out.println("Withdrawing $"+amount);
        printBalance();
    }
    public void transfer(String toWhere, double amount){
        balance -= amount;
        System.out.println("Transfering $"+amount+" to "+ toWhere);
        printBalance();
    }
    public void printBalance(){
        System.out.println("Your balance is now $"+balance);
    }
    public void showInfo(){
        System.out.println(
                "NAME: "+name+
                "\nACCOUNT NUMBER: "+ accountNumber+
                "\nBALANCE: "+balance+
                "\nRATE: "+rate+"%"
        );
    }


}
