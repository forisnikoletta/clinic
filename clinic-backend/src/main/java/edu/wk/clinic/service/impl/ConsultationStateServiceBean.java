package edu.wk.clinic.service.impl;

import edu.wk.clinic.dao.ConsultationDao;
import edu.wk.clinic.dao.DAOException;
import edu.wk.clinic.dao.StateDAO;
import edu.wk.clinic.enums.STATES;
import edu.wk.clinic.model.Consultation;
import edu.wk.clinic.model.Disease;
import edu.wk.clinic.model.State;
import edu.wk.clinic.model.User;
import edu.wk.clinic.service.ConsultationService;
import edu.wk.clinic.service.ConsultationStateService;
import edu.wk.clinic.service.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import java.util.Date;
import java.util.List;

public class ConsultationStateServiceBean implements ConsultationStateService {

    private static final Logger LOG = LoggerFactory.getLogger(ConsultationServiceBean.class);

    @EJB
    private ConsultationDao consultationDao;

    @EJB
    private StateDAO stateDAO;

    @Override
    public boolean createState(Consultation consultation, STATES state) throws ServiceException {
        State state1 = new State();
        state1.setDate(new Date());
        state1.setState(state);
        state1.setConsultation(consultation);
        try {
            stateDAO.create(state1);
            return true;
        } catch ( DAOException ex) {
            LOG.error("State create error!");
            throw new ServiceException("State create error!", ex);
        }
    }

    @Override
    public STATES getLastState(int consultationId) throws ServiceException {
        try {
            Consultation consultation = consultationDao.findById(consultationId);
            List<State> states = consultation.getStates();
            if(!states.isEmpty()) {
                return STATES.getState(states.get(states.size() - 1).getState());
            } else {
                return null;
            }
        } catch(DAOException ex) {
            LOG.error("Find by consultationId failed!");
            throw new ServiceException("Find by consultationId failed!", ex);
        }
    }



}
