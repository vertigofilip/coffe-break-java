package org.example;

import org.example.account;
import org.example.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/create")
    public ResponseEntity<account> createAccount(@RequestBody account newAccount) {
        account createdAccount = accountService.createAccount(newAccount.getName(), newAccount.getBalance(), newAccount.isActive());
        return ResponseEntity.ok(createdAccount);
    }

    @GetMapping("/list")
    public ResponseEntity<List<account>> getAllAccounts() {
        List<account> accounts = accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<account> getAccountById(@PathVariable int id) {
        account acc = accountService.getAccountById(id);
        if (acc != null) {
            return ResponseEntity.ok(acc);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{senderId}/transfer/{receiverId}")
    public ResponseEntity<Void> transferMoney(
            @PathVariable int senderId,
            @PathVariable int receiverId,
            @RequestParam int amount) {
        accountService.transferMoney(senderId, receiverId, amount);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/deposit")
    public ResponseEntity<Void> deposit(@PathVariable int id, @RequestParam int amount) {
        accountService.deposit(id, amount);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/withdraw")
    public ResponseEntity<Void> withdraw(@PathVariable int id, @RequestParam int amount) {
        accountService.withdraw(id, amount);
        return ResponseEntity.ok().build();
    }
}
