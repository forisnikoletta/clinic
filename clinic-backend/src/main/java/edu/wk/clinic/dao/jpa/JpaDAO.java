package edu.wk.clinic.dao.jpa;

import edu.wk.clinic.dao.DAO;
import edu.wk.clinic.dao.DAOException;
import edu.wk.clinic.model.BaseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.persistence.*;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolationException;
import java.util.List;


public abstract class JpaDAO<T extends BaseEntity> implements DAO<T> {

    private static final Logger LOG = LoggerFactory.getLogger(JpaDAO.class);

    private final Class<T> entityClass;

    @PersistenceContext(unitName = "clinicPu")
    EntityManager entityManager;

    public JpaDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public List<T> findAll() {
        try {
            TypedQuery<T> findAllQuery = entityManager.createQuery("from " + entityClass.getSimpleName(), entityClass);
            return findAllQuery.getResultList();
        } catch (PersistenceException ex) {
            LOG.error(entityClass.getClass() + " find all failed!", ex);
            throw new DAOException(entityClass.getClass() + " find all failed!", ex);
        }
    }

    @Override
    public T findById(long id) {
        try {
            return entityManager.find(entityClass, id);
        } catch (IllegalArgumentException ex) {
            LOG.error(entityClass.getClass() + " find by id failed!", ex);
            throw new DAOException(entityClass.getClass() + " find by id failed!", ex);
        }

    }

    @Override
    @Transactional
    public void create(T t) {
        try {
            entityManager.persist(t);
            LOG.info(t.getClass() + " entity created");
        } catch (ConstraintViolationException | EntityExistsException | IllegalArgumentException ex) {
            LOG.error(t.getClass() + " entity creation failed!", ex);
            throw new DAOException(t.getClass() + " entity creation failed!", ex);
        }
    }
}
