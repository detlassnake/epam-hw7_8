package ua.epam.hw7_8Test;

import org.junit.Before;
import org.junit.Test;
import ua.epam.hw7_8.model.Account;
import ua.epam.hw7_8.model.AccountStatus;
import ua.epam.hw7_8.repository.io.JavaIOAccountRepository;

import static org.junit.Assert.assertEquals;

public class AccountLogicTest {
    JavaIOAccountRepository javaIOAccountRepository;

    @Before
    public void setUp() {
        javaIOAccountRepository = new JavaIOAccountRepository();
    }

    @Test
    public void testLogicGetById() {
        setUp();
        Account result = new Account();
        result.setEmail("qwerty@gmail.com");
        result.setAccountStatus(AccountStatus.ACTIVE);
        Account input = javaIOAccountRepository.getById(1L);
        assertEquals(result.getEmail(), input.getEmail());
        assertEquals(result.getAccountStatus(), input.getAccountStatus());
    }

    @Test
    public void testLogicSaveDelete() {
        setUp();
        Account result = new Account();
        result.setEmail("qwerty");
        result.setAccountStatus(AccountStatus.BANNED);
        Account input = javaIOAccountRepository.save(result);
        assertEquals(result.getAccountStatus(), input.getAccountStatus());
        assertEquals(result.getEmail(), input.getEmail());
        javaIOAccountRepository.deleteById(input.getId());
    }
}
