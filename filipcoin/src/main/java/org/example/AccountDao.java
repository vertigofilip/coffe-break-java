package org.example;

import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

public interface AccountDao {
    @SqlUpdate("CREATE TABLE IF NOT EXISTS accounts (n_id INT NOT NULL PRIMARY KEY, n_name VARCHAR(255), n_balance INT, n_active BOOLEAN);")
    void createTable();

    @SqlUpdate("INSERT INTO accounts (n_id, n_name, n_balance, n_active) VALUES (:id, :name, ;balance, :active)")
    void insertUser(int id, String name, int balance, int active);

    @SqlQuery("SELECT * FROM accounts")
    @RegisterBeanMapper(account.class)
    List<account> listUsers();

    @SqlQuery("SELECT max(id) FROM accounts")
    @RegisterBeanMapper(account.class)
    int maxId();

    @SqlQuery("SELECT * FROM accounts WHERE id = :id")
    @RegisterBeanMapper(account.class)  // Note: Class names should follow Java naming conventions
    account getAccountById(int id);

    @SqlQuery("SELECT * FROM accounts WHERE id = :id")
    @RegisterBeanMapper(account.class)  // Note: Class names should follow Java naming conventions
    String[] getAccountByIdToo(int id);

    @SqlUpdate("UPDATE accounts SET balance = balance + :amount WHERE id = :id")
    void changeBalance(int id, int amount);
}