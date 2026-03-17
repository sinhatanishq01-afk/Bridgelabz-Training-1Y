class BankAccount {
    int accountNumber;
    double balance;

    BankAccount(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    void displayAccountType() {
        System.out.println("Generic Bank Account");
    }
}

class SavingsAccount extends BankAccount {
    double interestRate;

    SavingsAccount(int accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    void displayAccountType() {
        System.out.println("Savings Account");
    }
}

class CheckingAccount extends BankAccount {
    double withdrawalLimit;

    CheckingAccount(int accountNumber, double balance, double withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    void displayAccountType() {
        System.out.println("Checking Account");
    }
}

class FixedDepositAccount extends BankAccount {
    int tenure;

    FixedDepositAccount(int accountNumber, double balance, int tenure) {
        super(accountNumber, balance);
        this.tenure = tenure;
    }

    void displayAccountType() {
        System.out.println("Fixed Deposit Account");
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount a1 = new SavingsAccount(101, 50000, 4.5);
        BankAccount a2 = new CheckingAccount(102, 30000, 10000);
        BankAccount a3 = new FixedDepositAccount(103, 100000, 12);

        a1.displayAccountType();
        a2.displayAccountType();
        a3.displayAccountType();
    }
}