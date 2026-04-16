package com.gla.Generics;

import java.util.*;

class Account {
    int id;
    String name;

    Account(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account a = (Account) o;
        return id == a.id;
    }

    public int hashCode() {
        return Objects.hash(id);
    }

    public String toString() {
        return "Account{id=" + id + ", name='" + name + "'}";
    }
}

class Transaction {
    int id;
    int accountId;
    double amount;

    Transaction(int id, int accountId, double amount) {
        this.id = id;
        this.accountId = accountId;
        this.amount = amount;
    }

    public String toString() {
        return "Transaction{id=" + id + ", accountId=" + accountId + ", amount=" + amount + "}";
    }
}

public class Main {

    public static void main(String[] args) {

        List<Transaction> allTransactions = new ArrayList<>();
        Queue<Transaction> pendingQueue = new LinkedList<>();
        Set<Account> validAccounts = new HashSet<>();
        Stack<Transaction> stack = new Stack<>();

        validAccounts.add(new Account(1, "Aman"));
        validAccounts.add(new Account(2, "Riya"));

        pendingQueue.add(new Transaction(101, 1, 500));
        pendingQueue.add(new Transaction(102, 2, 1000));
        pendingQueue.add(new Transaction(103, 3, 700));

        while (!pendingQueue.isEmpty()) {
            Transaction t = pendingQueue.poll();

            Account temp = new Account(t.accountId, "");

            if (validAccounts.contains(temp)) {
                System.out.println("Processing: " + t);
                allTransactions.add(t);
                stack.push(t);
            } else {
                System.out.println("Invalid Account for: " + t);
            }
        }

        System.out.println("\nRolling Back Last Transaction:");

        if (!stack.isEmpty()) {
            Transaction last = stack.pop();
            allTransactions.remove(last);
            System.out.println("Rolled Back: " + last);
        }

        System.out.println("\nFinal Transactions:");
        for (Transaction t : allTransactions) {
            System.out.println(t);
        }
    }
}