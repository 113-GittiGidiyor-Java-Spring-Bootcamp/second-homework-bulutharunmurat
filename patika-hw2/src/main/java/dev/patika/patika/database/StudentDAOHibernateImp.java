package dev.patika.patika.database;

import dev.patika.patika.model.Student;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;


@Repository
public class StudentDAOHibernateImp implements StudentDAO<Student>{

    private EntityManager entityManager;

    @Autowired
    public StudentDAOHibernateImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Student> findAll() {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("from Student s", Student.class).getResultList();
    }

    @Override
    public Student findById(int id) {
        return null;
    }

    @Override
    @Transactional
    public Student save(Student student) {
        Session session = entityManager.unwrap(Session.class);
        return (Student) session.merge(student);
    }

    @Override
    public Student update(Student object) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }

}
