package dev.patika.patika.database;

import org.springframework.stereotype.Repository;

@Repository
public interface CourseDAO<Course> extends BaseDatabaseAccessObject<Course> {
}
