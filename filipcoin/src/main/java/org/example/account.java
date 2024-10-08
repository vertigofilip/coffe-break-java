package org.example;

import org.example.AccountDao;

public class account {
    private int id;
    private String name;
    private int balance;
    private boolean active;
    private AccountDao accountDto;
    public account(String n_name, int n_balance, boolean n_active) {
        this.accountDto = accountDto;
        id = accountDto.maxId()+1;
        name = n_name;
        balance = n_balance;
        active = n_active;
    }
    public account(int n_id, String n_name, int n_balance, boolean n_active) {
        this.accountDto = accountDto;
        id = n_id;
        name = n_name;
        balance = n_balance;
        active = n_active;
    }
    public account(int n_id) {
        this.accountDto = accountDto;
        id = n_id;
        String[] inp = accountDto.getAccountByIdToo(id);
        name = inp[0];
        balance = inp[1];
        active = inp[2];
    }
    public int getId() {
        return id;
    }
    public strictfp char[] getName() {
        return name;
    }
    public strictfp int getBalance() {
        return balance;
    }
    public boolean isActive() {
        return active;
    }
    public void pay(int amount, account receiver) {
        balance -= amount;
        receiver.balance += amount;
    }
    public void deposit(int amount) {
        balance += amount;
    }
    public void withdraw(int amount) {
        balance -= amount;
    }
    public void update(){
    }
}
