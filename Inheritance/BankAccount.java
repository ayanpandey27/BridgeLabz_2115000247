class BankAccount {
    protected String accountNumber;
    protected double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void displayDetails() {
        System.out.println("Account Number: " + accountNumber + ", Balance: $" + balance);
    }
}

class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Account Type: Savings Account, Interest Rate: " + interestRate + "%");
    }
}

class CheckingAccount extends BankAccount {
    private double withdrawalLimit;

    public CheckingAccount(String accountNumber, double balance, double withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Account Type: Checking Account, Withdrawal Limit: $" + withdrawalLimit);
    }
}

class FixedDepositAccount extends BankAccount {
    private int depositTerm;

    public FixedDepositAccount(String accountNumber, double balance, int depositTerm) {
        super(accountNumber, balance);
        this.depositTerm = depositTerm;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Account Type: Fixed Deposit Account, Deposit Term: " + depositTerm + " months");
    }
}

public class BankSystem {
    public static void main(String[] args) {
        SavingsAccount savings = new SavingsAccount("SA123", 5000.0, 2.5);
        CheckingAccount checking = new CheckingAccount("CA456", 3000.0, 1000.0);
        FixedDepositAccount fixedDeposit = new FixedDepositAccount("FD789", 10000.0, 12);
        
        savings.displayDetails();
        System.out.println();
        checking.displayDetails();
        System.out.println();
        fixedDeposit.displayDetails();
    }
}

