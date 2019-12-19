package ua.epam.hw7_8.controller;

import ua.epam.hw7_8.model.Developer;
import ua.epam.hw7_8.repository.DeveloperRepository;
import ua.epam.hw7_8.repository.io.JavaIODeveloperRepository;
import java.util.ArrayList;

public class DeveloperController {
    private DeveloperRepository developerRepository;

    public DeveloperController() {
        developerRepository = new JavaIODeveloperRepository();
    }

    public void create(Developer developer) {
        developerRepository.save(developer);
    }

    public ArrayList read() {
        return developerRepository.getAll();
    }

    public Developer readById(long id) {
        return developerRepository.getById(id);
    }

    public void edit(long id, Developer developer) {
        developerRepository.update(id, developer);
    }

    public void delete(long id) {
        developerRepository.deleteById(id);
    }
}