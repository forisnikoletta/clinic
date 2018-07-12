package edu.wk.clinic.service;



import edu.wk.clinic.model.Consultation;
import edu.wk.clinic.model.Disease;
import edu.wk.clinic.model.User;

import java.util.List;

public interface DiseaseService {

    boolean createDisease(Disease disease
    ) throws ServiceException;

    Disease getDisease(long diseaseId) throws ServiceException;

    List<Disease> getAllDisease() throws ServiceException;
}
