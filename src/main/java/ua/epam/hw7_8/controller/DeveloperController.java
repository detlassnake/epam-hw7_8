package ua.epam.hw7_8.controller;

import ua.epam.hw7_8.model.Developer;
import ua.epam.hw7_8.repository.io.JavaIODeveloperRepository;
import java.util.ArrayList;

public class DeveloperController {
    private JavaIODeveloperRepository javaIODeveloperRepository = new JavaIODeveloperRepository();

    public void create(Developer developer) {
        javaIODeveloperRepository.writeDataToFile(developer);
    }

    public ArrayList read() {
        return javaIODeveloperRepository.readDataFromFile();
    }

    public Developer readById(long id) {
        return javaIODeveloperRepository.readDataFromFileById(id);
    }

    public void edit(long id, Developer developer) {
        javaIODeveloperRepository.editDataFromFile(id, developer);
    }

    public void delete(long id) {
        javaIODeveloperRepository.deleteDataFromFile(id);
    }
}