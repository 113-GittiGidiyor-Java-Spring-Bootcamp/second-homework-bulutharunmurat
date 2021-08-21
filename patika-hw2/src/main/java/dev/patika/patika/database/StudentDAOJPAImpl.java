package dev.patika.patika.database;

import dev.patika.patika.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class StudentDAOJPAImpl implements StudentDAO<Student>{

    private EntityManager entityManager;

    @Autowired
    public StudentDAOJPAImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Student> findAll() {
        return entityManager.createQuery("from Student s", Student.class).getResultList();
    }

    @Override
    public Student findById(int id) {
        return null;
    }

    @Override
    @Transactional
    public Student save(Student student) {
        return entityManager.merge(student);
    }

    @Override
    public void deleteFromDatabase(Student object) {

    }

    @Override
    public void deleteFromDatabase(int id) {

    }

    @Override
    public void updateOnDatabase(Student object, int id) {

    }
}
