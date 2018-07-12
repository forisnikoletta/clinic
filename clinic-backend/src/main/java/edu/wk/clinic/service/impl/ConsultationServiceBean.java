package edu.wk.clinic.service.impl;

import edu.wk.clinic.dao.ConsultationDao;
import edu.wk.clinic.dao.DAOException;
import edu.wk.clinic.dao.StateDAO;
import edu.wk.clinic.model.Consultation;
import edu.wk.clinic.model.Disease;
import edu.wk.clinic.model.User;
import edu.wk.clinic.service.ConsultationService;
import edu.wk.clinic.service.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import java.util.Date;
import java.util.List;

public class ConsultationServiceBean implements ConsultationService {

    private static final Logger LOG = LoggerFactory.getLogger(ConsultationServiceBean.class);

    @EJB
    private ConsultationDao consultationDao;



    @Override
    public boolean Consultation(User user, Disease disease) throws ServiceException {
        try {
            Consultation consultation = new Consultation();
            consultation.setDisease(disease);
            consultation.setUser(user);
            consultation.setDate(new Date());
            consultationDao.create(consultation);
            return true;
        } catch (DAOException ex) {
            LOG.error("Consultation exception!");
            throw new ServiceException("Consultation exception", ex);
        }
    }

    @Override
    public List<Consultation> getAllConsultations(User user) throws ServiceException {
        try {
            return consultationDao.findAllByUserId(user.getId());
        } catch (DAOException ex) {
            LOG.error("Consultation exception!");
            throw new ServiceException("Consultation exception", ex);
        }
    }

    @Override
    public Consultation getConsulation(long consultationId) throws ServiceException {
        try {
            return consultationDao.findById(consultationId);
        } catch (DAOException ex) {
            LOG.error("Consultation exception!");
            throw new ServiceException("Consultation exception", ex);
        }
    }

    @Override
    public List<Consultation> getConsultations(Disease disease) throws ServiceException {
        try {
            return consultationDao.findAllByDiseaseId(disease.getId());
        } catch (DAOException ex) {
            LOG.error("Consultation exception!");
            throw new ServiceException("Consultation exception", ex);
        }
    }

}
