package dev.patika.patika.database;

import dev.patika.patika.model.Course;
import dev.patika.patika.model.Instructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class InstructorDAOJPAImpl implements InstructorDAO<Instructor>{

    private static final Logger logger = LoggerFactory.getLogger(StudentDAOJPAImpl.class);
    private EntityManager entityManager;

    @Autowired
    public InstructorDAOJPAImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Instructor> findAll() {
        return entityManager.createQuery("FROM Instructor i", Instructor.class).getResultList();
    }

    @Override
    public Instructor findById(int id) {
        return entityManager.find(Instructor.class, id);
    }

    @Override
    @Transactional
    public Instructor save(Instructor instructor) {
        return entityManager.merge(instructor);
    }

    @Override
    @Transactional
    public Instructor update(Instructor instructor) {

        Instructor foundInstructor = null;
        try {
            foundInstructor = this.findById(instructor.getId());

            foundInstructor.setName(instructor.getName());
            foundInstructor.setAddress(instructor.getAddress());
            foundInstructor.setPhoneNumber(instructor.getPhoneNumber());
            entityManager.merge(foundInstructor);

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }

        return foundInstructor;
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Instructor instructor= this.findById(id);
        if(instructor == null){
            logger.error("There is no instructor with id: " + id);
        }
        entityManager.remove(instructor);
    }
}
