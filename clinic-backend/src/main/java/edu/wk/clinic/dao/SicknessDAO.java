package edu.wk.clinic.dao;

import edu.wk.clinic.model.Sickness;

import javax.ejb.Local;

@Local
public interface SicknessDAO extends DAO<Sickness> {

    Sickness findByName(String name);

}
