package edu.wk.clinic.service;

import edu.wk.clinic.enums.STATES;
import edu.wk.clinic.model.Consultation;

public interface ConsultationStateService {

    boolean createState(Consultation consultation, STATES state) throws ServiceException;

    STATES getLastState(int consultationId) throws ServiceException;
}
