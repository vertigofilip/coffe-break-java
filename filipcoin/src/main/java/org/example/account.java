package org.example;

import org.example.AccountDao;

public class account {
    private int id;
    private String name;
    private int balance;
    private boolean active;
    private AccountDao accountDto;
    public account(String n_name, int n_balance, boolean n_active) {//for creating new accounts
        this.accountDto = accountDto;
        id = accountDto.maxId()+1;
        name = n_name;
        balance = n_balance;
        active = n_active;
        accountDto.insertUser(id, name, balance, active);
    }
    public account(int n_id, String n_name, int n_balance, boolean n_active) {//for outside imprt mechanism
        this.accountDto = accountDto;
        id = n_id;
        name = n_name;
        balance = n_balance;
        active = n_active;
    }
    public account(int n_id) {//for import in loop from 0 to max_id
        this.accountDto = accountDto;
        id = n_id;
        String[] inp = accountDto.getAccountByIdToo(id);
        name = inp[0];
        try {
            this.balance = Integer.parseInt(inp[1]);  // Convert String to int
        } catch (NumberFormatException e) {
            System.out.println("Error parsing balance: " + e.getMessage());
            this.balance = 0;  // Set a default value in case of error
        }
        this.active = Boolean.parseBoolean(inp[2]);
    }
    public int getId() {
        return id;
    }
    public strictfp String getName() {
        return name;
    }
    public strictfp int getBalance() {
        return balance;
    }
    public boolean isActive() {
        return active;
    }
    public void deposit(int amount) {//ads requested ammount of money to account (used by admin or other functions)
        this.accountDto.changeBalance(this.id, amount);
        balance += amount;
    }
    public void withdraw(int amount) {//removes requested ammount of money to account (used by admin or other functions)
        this.accountDto.changeBalance(this.id, 0-amount);
        balance -= amount;
    }
    public void pay(int amount, account receiver) {//used by user to send money
        if(this.balance >= amount && this.active) {
            this.withdraw(amount);
            receiver.deposit(amount);
        }
    }
    public void update(){//update local data to be like the one in database
        String[] inp = accountDto.getAccountByIdToo(id);
        name = inp[0];
        try {
            this.balance = Integer.parseInt(inp[1]);  // Convert String to int
        } catch (NumberFormatException e) {
            System.out.println("Error parsing balance: " + e.getMessage());
            this.balance = 0;  // Set a default value in case of error
        }
        this.active = Boolean.parseBoolean(inp[2]);
    }
}
