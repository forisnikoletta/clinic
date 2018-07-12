package edu.wk.clinic.service;

import edu.wk.clinic.model.Consultation;
import edu.wk.clinic.model.Disease;
import edu.wk.clinic.model.User;

import java.util.Collection;
import java.util.List;

public interface ConsultationService {


    boolean Consultation(User user, Disease disease) throws ServiceException;

    List<Consultation> getAllConsultations(User user) throws ServiceException;

    Consultation getConsulation(long consultationId) throws ServiceException;

    List<Consultation> getConsultations(Disease disease) throws ServiceException;
}
