package edu.wk.clinic.dao.jpa;

import edu.wk.clinic.dao.DiseaseDAO;
import edu.wk.clinic.model.Disease;

import javax.ejb.Stateless;

@Stateless
public class DiseaseJpaDAO extends JpaDAO<Disease> implements DiseaseDAO {
    public DiseaseJpaDAO(){
        super(Disease.class);
    }
}
