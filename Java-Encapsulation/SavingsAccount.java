package com.gla.encapsulation;

public class SavingsAccount extends BankAccount implements Loanable {

    public SavingsAccount(String acc, String name, double bal) {
        super(acc, name, bal);
    }

    public double calculateInterest() {
        return balance * 0.04;
    }

    public void applyForLoan() {
        System.out.println("Loan Applied");
    }

    public boolean calculateLoanEligibility() {
        return balance > 5000;
    }
}