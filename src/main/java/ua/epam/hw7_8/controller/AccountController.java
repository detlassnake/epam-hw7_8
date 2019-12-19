package ua.epam.hw7_8.controller;

import ua.epam.hw7_8.model.Account;
import ua.epam.hw7_8.repository.AccountRepository;
import ua.epam.hw7_8.repository.io.JavaIOAccountRepository;
import java.util.ArrayList;

public class AccountController {
    private AccountRepository accountRepository;

    public AccountController() {
        accountRepository = new JavaIOAccountRepository();
    }

    public Account create(Account account) {
        return accountRepository.save(account);
    }

    public ArrayList read() {
        return accountRepository.getAll();
    }

    public Account readById(long id) {
        return accountRepository.getById(id);
    }

    public void editById(long id, Account account) {
        accountRepository.update(id, account);
    }

    public void delete(long id) {
        accountRepository.deleteById(id);
    }
}