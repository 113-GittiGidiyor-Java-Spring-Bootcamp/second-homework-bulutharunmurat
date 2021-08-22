package dev.patika.patika.database;

import dev.patika.patika.model.Instructor;
import dev.patika.patika.model.PermanentInstructor;
import dev.patika.patika.model.VisitingResearcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class PermanentInstructorDAOImpl implements PermanentInstructorDAO<PermanentInstructor> {

    private static final Logger logger = LoggerFactory.getLogger(StudentDAOJPAImpl.class);
    private EntityManager entityManager;

    @Autowired
    public PermanentInstructorDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<PermanentInstructor> findAll() {
        return entityManager.createQuery("FROM Instructor i", PermanentInstructor.class).getResultList();
    }

    @Override
    public PermanentInstructor findById(int id) {
        return entityManager.find(PermanentInstructor.class, id);
    }

    @Override
    @Transactional
    public PermanentInstructor save(PermanentInstructor permanentInstructor) {
        return entityManager.merge(permanentInstructor);
    }

    @Override
    @Transactional
    public PermanentInstructor update(PermanentInstructor permanentInstructor) {
        PermanentInstructor foundInstructor = null;

        try {
            foundInstructor = this.findById(permanentInstructor.getId());

            foundInstructor.setName(permanentInstructor.getName());
            foundInstructor.setAddress(permanentInstructor.getAddress());
            foundInstructor.setPhoneNumber(permanentInstructor.getPhoneNumber());
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
        Instructor permanentInstructor= this.findById(id);
        if(permanentInstructor == null){
            logger.error("There is no instructor with id: " + id);
        }
        entityManager.remove(permanentInstructor);
    }
}
