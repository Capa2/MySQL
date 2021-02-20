package entities;

import java.util.List;

public class Account {
    int id;
    String accountName;
    Customer customer;
    List<Transaction> transactions;

    public Account(Customer customer) {
        this.customer = customer;
        this.accountName = "Deposit Account";
    }
    public Account(Customer customer, String accountName) {
        this.customer = customer;
        this.accountName = accountName;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
