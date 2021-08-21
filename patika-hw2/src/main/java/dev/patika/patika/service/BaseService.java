package dev.patika.patika.service;

import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BaseService <T>{

    List<T> findAll();
    T findById(int id);
    T save(T object);
    T update(T object);
    void deleteById(int id);
}
