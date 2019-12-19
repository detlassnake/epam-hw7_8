package ua.epam.hw7_8.repository;

import java.util.ArrayList;

public interface GenericRepository<T, ID> {
    T save(T data);
    ArrayList<T> getAll();
    T getById(ID id);
    void update(ID id, T data);
    void deleteById(ID id);
}