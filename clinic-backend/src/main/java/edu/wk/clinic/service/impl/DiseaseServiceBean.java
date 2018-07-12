package edu.wk.clinic.service.impl;

import edu.wk.clinic.dao.DAOException;
import edu.wk.clinic.dao.DiseaseDAO;
import edu.wk.clinic.dao.SicknessDAO;
import edu.wk.clinic.model.Disease;
import edu.wk.clinic.model.Sickness;
import edu.wk.clinic.service.DiseaseService;
import edu.wk.clinic.service.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;



public class DiseaseServiceBean  implements DiseaseService {

    private static final Logger LOG = LoggerFactory.getLogger(DiseaseServiceBean.class);

    @EJB
    private SicknessDAO sicknessDAO;

    @EJB
    private DiseaseDAO diseaseDAO;

    @Override
    public boolean createDisease(Disease disease) throws ServiceException {
        if (disease.getName().isEmpty() || disease.getSicknesses().isEmpty()) return false;
        Set<Sickness> sicknesses = disease.getSicknesses();
        Iterator<Sickness> iterator = sicknesses.iterator();
        Set<Sickness> sicknessSet = new HashSet<>();
        try {
            while (iterator.hasNext()) {
                Sickness sickness1 = iterator.next();
                Sickness sickness2 = sicknessDAO.findByName(sickness1.getName());
                if (sickness2 == null) {
                    sicknessDAO.create(sickness1);
                    sickness2 = sicknessDAO.findByName(sickness1.getName());
                    if (sickness2 != null) {
                        sicknessSet.add(sickness2);
                    }
                } else {
                    sicknessSet.add(sickness2);
                }
            }
            disease.setSicknesses(sicknessSet);
            diseaseDAO.create(disease);
            return true;
        } catch (DAOException ex) {
            LOG.info("Disease Service exception");
            throw new ServiceException("Disease Service exception", ex);
        }
    }

    @Override
    public Disease getDisease(long diseaseId) throws ServiceException {
        try {
            return diseaseDAO.findById(diseaseId);
        } catch (DAOException ex) {
            LOG.info("Disease Service exception");
            throw new ServiceException("Disease Service exception", ex);
        }
    }

    @Override
    public List<Disease> getAllDisease() throws ServiceException {
        try {
            return diseaseDAO.findAll();
        } catch (DAOException ex) {
            LOG.info("Disease Service exception");
            throw new ServiceException("Disease Service exception", ex);
        }
    }

}
