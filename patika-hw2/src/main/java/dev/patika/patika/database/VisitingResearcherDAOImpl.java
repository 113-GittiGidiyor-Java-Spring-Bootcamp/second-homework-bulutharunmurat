package dev.patika.patika.database;

import dev.patika.patika.model.Instructor;
import dev.patika.patika.model.VisitingResearcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class VisitingResearcherDAOImpl implements VisitingResearcherDAO<VisitingResearcher>{

    private static final Logger logger = LoggerFactory.getLogger(StudentDAOJPAImpl.class);
    private EntityManager entityManager;

    @Autowired
    public VisitingResearcherDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<VisitingResearcher> findAll() {
        return entityManager.createQuery("FROM Instructor i", VisitingResearcher.class).getResultList();
    }

    @Override
    public VisitingResearcher findById(int id) {
        return entityManager.find(VisitingResearcher.class, id);
    }

    @Override
    @Transactional
    public VisitingResearcher save(VisitingResearcher visitingResearcher) {
        return entityManager.merge(visitingResearcher);
    }

    @Override
    @Transactional
    public VisitingResearcher update(VisitingResearcher visitingResearcher) {
        VisitingResearcher foundInstructor = null;

        try {
            foundInstructor = this.findById(visitingResearcher.getId());

            foundInstructor.setName(visitingResearcher.getName());
            foundInstructor.setAddress(visitingResearcher.getAddress());
            foundInstructor.setPhoneNumber(visitingResearcher.getPhoneNumber());
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
        Instructor visitingResearcher= this.findById(id);
        if(visitingResearcher == null){
            logger.error("There is no instructor with id: " + id);
        }
        entityManager.remove(visitingResearcher);
    }
}
