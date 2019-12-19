package ua.epam.hw7_8Test;

import org.junit.Before;
import org.junit.Test;
import ua.epam.hw7_8.model.Account;
import ua.epam.hw7_8.model.AccountStatus;
import ua.epam.hw7_8.model.Developer;
import ua.epam.hw7_8.model.Skill;
import ua.epam.hw7_8.repository.io.JavaIODeveloperRepository;
import static org.junit.Assert.assertEquals;

public class DeveloperLogicTest {
    JavaIODeveloperRepository javaIODeveloperRepository;
    Account account;
    Skill skill;
    @Before
    public void setUp() {
        javaIODeveloperRepository = new JavaIODeveloperRepository();
        account = new Account();
        account.setEmail("joke@mail.ru");
        account.setAccountStatus(AccountStatus.ACTIVE);
        skill = new Skill();
        skill.setId(9L);
        skill.setSkill("CSS");
    }

    @Test
    public void testLogicGetById() {
        setUp();
        Developer result = new Developer();
        result.setName("Vova");
        result.setDevAccount(account);
        result.setDevSkills(skill);
        Developer input = javaIODeveloperRepository.getById(1L);
        assertEquals(result.getName(), input.getName());
        assertEquals(result.getDevAccount().getEmail(), input.getDevAccount().getEmail());
        assertEquals(result.getDevAccount().getAccountStatus(), input.getDevAccount().getAccountStatus());
    }
}