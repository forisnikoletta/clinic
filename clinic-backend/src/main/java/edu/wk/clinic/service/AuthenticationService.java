package edu.wk.clinic.service;

import edu.wk.clinic.model.User;

import javax.ejb.Local;
import java.util.List;


@Local
public interface AuthenticationService {
	void register(User newUser) throws ServiceException;

	User validatePassword(String email, String password) throws ServiceException;

	List<User> findAllUsers() throws ServiceException;

	User findByEmail(String username) throws ServiceException;
}
