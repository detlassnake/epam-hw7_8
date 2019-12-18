package ua.epam.hw7_8.controller;

import ua.epam.hw7_8.model.Account;
import ua.epam.hw7_8.repository.io.JavaIOAccountRepository;
import java.util.ArrayList;

public class AccountController {
    private JavaIOAccountRepository javaIOAccountRepository = new JavaIOAccountRepository();

    public Account create(Account account) {
        return javaIOAccountRepository.writeDataToFile(account);
    }

    public ArrayList read() {
        return javaIOAccountRepository.readDataFromFile();
    }

    public Account readById(long id) {
        return javaIOAccountRepository.readDataFromFileById(id);
    }

    public void editById(long id, Account account) {
        javaIOAccountRepository.editDataFromFile(id, account);
    }

    public void delete(long id) {
        javaIOAccountRepository.deleteDataFromFile(id);
    }
}