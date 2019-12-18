package ua.epam.hw7_8.repository;

import java.util.ArrayList;

public interface GenericRepository<T, ID> {
    T writeDataToFile(T data);
    ArrayList<T> readDataFromFile();
    T readDataFromFileById(ID id);
    void editDataFromFile(ID id, T data);
    void deleteDataFromFile(ID id);
}