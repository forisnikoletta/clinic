package edu.wk.clinic.dao;

import edu.wk.clinic.model.User;

import javax.ejb.Local;


@Local
public interface UserDAO extends DAO<User> {
	User findByEmail(String username);
}
