package ua.epam.hw7_8.controller;

import ua.epam.hw7_8.model.Skill;
import ua.epam.hw7_8.repository.SkillRepository;
import ua.epam.hw7_8.repository.io.JavaIOSkillRepository;
import java.util.ArrayList;

public class SkillController {
    private SkillRepository skillRepository;

    public SkillController() {
        skillRepository = new JavaIOSkillRepository();
    }

    public Skill create(Skill skill) {
        return skillRepository.save(skill);
    }

    public ArrayList read() {
        return skillRepository.getAll();
    }

    public Skill readById(long id) {
        return skillRepository.getById(id);
    }

    public void edit(long id, Skill skill) {
        skillRepository.update(id, skill);
    }

    public void delete(long id) {
        skillRepository.deleteById(id);
    }
}