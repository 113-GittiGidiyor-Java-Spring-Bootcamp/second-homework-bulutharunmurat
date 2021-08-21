package dev.patika.patika.database;

import org.springframework.stereotype.Repository;

@Repository
public interface StudentDAO<Student> extends BaseDatabaseAccessObject<Student>{
}
