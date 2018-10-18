package bankaccountapp;

public class Savings extends Account{
    // List properties specific to the Savings account
    private int safetyDepositBoxID;
    private int safetyDepositBoxPin;

    // Constructor to initialize settings for the Savings account
    public Savings(String name, String sSN, double initDeposit){
        super(name,sSN,initDeposit);
        accountNumber = 1+accountNumber;
        setSafetyDepositBox();
    }

    private void setSafetyDepositBox(){
        safetyDepositBoxID = (int)(Math.random() * Math.pow(10,3));
        safetyDepositBoxPin = (int)(Math.random() * Math.pow(10,4));
    }

    @Override
    public void setRate(){
        rate = getBaseRate() - 0.25;
    }

    // List any methods specific to savings account
    public void showInfo(){
        System.out.println("ACCOUNT TYPE: Savings");
        super.showInfo();
        System.out.println(" Your Savings Account Features: " +
                "\n   Safety Deposit Box ID : "+safetyDepositBoxID+
                "\n   Safety Deposit Box PIN: "+safetyDepositBoxPin);

    }
}
