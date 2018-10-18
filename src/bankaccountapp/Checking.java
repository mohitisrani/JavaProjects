package bankaccountapp;

public class Checking extends Account {
    //List properties specific to a checking account
    private int debitCardNumber;
    private int debitCardPin;


    //Constructor to initialize checking account properties
    public Checking(String name, String sSN, double initDeposit){
        super(name,sSN,initDeposit); // super is required only if there is need to pass arguments
        accountNumber = 2+accountNumber;

        // Set Debit Card
        setDebitCart();
    }

    @Override
    public void setRate() {
        rate = getBaseRate() * 0.15;
    }

    //List any methods specific to the checking account
    private void setDebitCart(){
        debitCardNumber = (int)(Math.random() * Math.pow(10,12));
        debitCardPin = (int)(Math.random() * Math.pow(10,4));
    }

    public void showInfo(){
        System.out.println("ACCOUNT TYPE: Checking");
        super.showInfo();
        System.out.println(" Your Checking Account Features: " +
                "\n   Debit Card Number : "+debitCardNumber+
                "\n   Debit Card PIN: "+debitCardPin);
    }
}
