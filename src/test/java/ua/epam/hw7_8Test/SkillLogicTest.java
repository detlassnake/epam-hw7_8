package ua.epam.hw7_8Test;

import org.junit.Before;
import org.junit.Test;
import ua.epam.hw7_8.model.Skill;
import ua.epam.hw7_8.repository.io.JavaIOSkillRepository;
import static org.junit.Assert.assertEquals;

public class SkillLogicTest {
    JavaIOSkillRepository javaIOSkillRepository;

    @Before
    public void setUp() {
        javaIOSkillRepository = new JavaIOSkillRepository();
    }

    @Test
    public void testLogicGetById() {
        setUp();
        Skill result = new Skill();
        result.setId(1L);
        result.setSkill("java");
        Skill input = javaIOSkillRepository.getById(1L);
        assertEquals(result.getSkill(), input.getSkill());
    }

    @Test
    public void testLogicSaveDelete() {
        setUp();
        Skill result = new Skill();
        result.setSkill("fava");
        Skill input = javaIOSkillRepository.save(result);
        assertEquals(result.getSkill(), input.getSkill());
        javaIOSkillRepository.deleteById(input.getId());
    }
}