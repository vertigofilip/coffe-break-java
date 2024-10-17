package org.example;

import org.example.AccountDao;
import org.example.account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountDao accountDao;

    public account createAccount(String name, int balance, boolean active) {
        int id = accountDao.maxId() + 1;
        account newAccount = new account(id, name, balance, active);
        accountDao.insertUser(id, name, balance, active);
        return newAccount;
    }

    public List<account> getAllAccounts() {
        return accountDao.listUsers();
    }

    public account getAccountById(int id) {
        return accountDao.getAccountById(id);
    }

    public void transferMoney(int senderId, int receiverId, int amount) {
        account sender = accountDao.getAccountById(senderId);
        account receiver = accountDao.getAccountById(receiverId);
        sender.pay(amount, receiver);
    }

    public void deposit(int id, int amount) {
        accountDao.changeBalance(id, amount);
    }

    public void withdraw(int id, int amount) {
        accountDao.changeBalance(id, -amount);
    }
}
