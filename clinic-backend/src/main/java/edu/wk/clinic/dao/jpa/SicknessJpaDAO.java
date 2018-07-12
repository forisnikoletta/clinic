package edu.wk.clinic.dao.jpa;

import edu.wk.clinic.dao.DAOException;
import edu.wk.clinic.dao.SicknessDAO;
import edu.wk.clinic.model.Sickness;

import javax.ejb.Stateless;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class SicknessJpaDAO extends JpaDAO<Sickness> implements SicknessDAO {

    public SicknessJpaDAO() {
        super(Sickness.class);
    }

    @Override
    public Sickness findByName(String name) {
        TypedQuery<Sickness> query = entityManager.createNamedQuery(Sickness.QUERY_FIND_BY_NAME, Sickness.class);
        query.setParameter("name", name);

        try {
            List<Sickness> Sicknesss = query.getResultList();
            if (Sicknesss.isEmpty()) {
                return null;
            }
            return Sicknesss.get(0);
        } catch(PersistenceException ex) {
            throw new DAOException("Sickness JPA Connection error!", ex);
        }
    }
}

