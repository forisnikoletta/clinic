package edu.wk.clinic.dao.jpa;

import edu.wk.clinic.dao.ConsultationDao;
import edu.wk.clinic.dao.DAOException;
import edu.wk.clinic.model.Consultation;
import edu.wk.clinic.model.Disease;

import javax.ejb.Stateless;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class ConsulationJpaDAO extends JpaDAO<Consultation> implements ConsultationDao {
    public ConsulationJpaDAO() {
        super(Consultation.class);
    }

    @Override
    public List<Consultation> findAllByUserId(long userId) {
        TypedQuery<Consultation> query = entityManager.createNamedQuery(Consultation.QUERY_FIND_BY_USER, Consultation.class);
        query.setParameter("userId", userId);

        try {
            return query.getResultList();
        } catch(PersistenceException ex) {
            throw new DAOException("Disease connection error!", ex);
        }
    }

    @Override
    public List<Consultation> findAllByDiseaseId(long DiseaseId) {
        TypedQuery<Consultation> query = entityManager.createNamedQuery(Consultation.QUERY_FIND_BY_DISEASE, Consultation.class);
        query.setParameter("DiseaseId", DiseaseId);

        try {
            return query.getResultList();
        } catch(PersistenceException ex) {
            throw new DAOException("Consultation connection error!", ex);
        }
    }
}
