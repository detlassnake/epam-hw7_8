package ua.epam.hw7_8.controller;

import ua.epam.hw7_8.model.Skill;
import ua.epam.hw7_8.repository.io.JavaIOSkillRepository;
import java.util.ArrayList;

public class SkillController {
    private JavaIOSkillRepository javaIOSkillRepository = new JavaIOSkillRepository();

    public Skill create(Skill skill) {
        return javaIOSkillRepository.writeDataToFile(skill);
    }

    public ArrayList read() {
        return javaIOSkillRepository.readDataFromFile();
    }

    public Skill readById(long id) {
        return javaIOSkillRepository.readDataFromFileById(id);
    }

    public void edit(long id, Skill skill) {
        javaIOSkillRepository.editDataFromFile(id, skill);
    }

    public void delete(long id) {
        javaIOSkillRepository.deleteDataFromFile(id);
    }
}