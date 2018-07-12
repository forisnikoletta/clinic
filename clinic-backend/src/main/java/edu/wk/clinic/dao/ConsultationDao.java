package edu.wk.clinic.dao;

import edu.wk.clinic.model.Consultation;

import javax.ejb.Local;
import java.util.Collection;
import java.util.List;

@Local
public interface ConsultationDao extends DAO<Consultation> {

    // CRUD methods specific to this entity
    List<Consultation> findAllByUserId(long userId);

    List<Consultation> findAllByDiseaseId(long DiseaseId);
}
