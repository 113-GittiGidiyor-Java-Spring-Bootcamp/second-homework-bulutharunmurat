package dev.patika.patika.database;

import java.util.List;

public interface BaseDatabaseAccessObject<T>{

    List<T> findAll();
    T findById(int id);
    T save(T object);
    T update(T object);
    void deleteFromDatabase(T object);
    void deleteById(int id);
    void updateOnDatabase(T object, int id);

}
