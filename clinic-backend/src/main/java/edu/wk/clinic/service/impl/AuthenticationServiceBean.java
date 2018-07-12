package edu.wk.clinic.service.impl;

import edu.wk.clinic.dao.DAOException;
import edu.wk.clinic.dao.UserDAO;
import edu.wk.clinic.enums.USER_ROLES;
import edu.wk.clinic.model.User;
import edu.wk.clinic.password.PasswordEncrypter;
import edu.wk.clinic.service.AuthenticationService;
import edu.wk.clinic.service.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;


@Stateless
public class AuthenticationServiceBean implements AuthenticationService {
	
	private static final Logger LOG = LoggerFactory.getLogger(AuthenticationServiceBean.class);
	
	@EJB
	private UserDAO userDao;
	
	@EJB
	private PasswordEncrypter passwordEncrypter;

	@Override
	public void register(User newUser) throws ServiceException {

		if(checkUserData(newUser)) {
			if(userDao.findByEmail(newUser.getEmail()) == null) {
				String encryptedPassword = passwordEncrypter.createHash(newUser.getPassword());
				newUser.setPassword(encryptedPassword);
				newUser.setRole(USER_ROLES.USER);
				try {
					userDao.create(newUser);
				} catch (DAOException ex) {
					LOG.error("Already existing email!");
					throw new ServiceException("Already existing email address!", ex);
				}
			} else {
				LOG.error("Already existing email!");
				throw new ServiceException("Already existing email address!");
			}
		} else {
			LOG.error("All field are required!");
			throw new ServiceException("All field are required!");
		}
	}
	private boolean checkUserData(User user){
		if(user.getLast().isEmpty()) return false;
		if (user.getFirst().isEmpty()) return false;
		if (user.getPhone().isEmpty()) return false;
		if (user.getEmail().isEmpty()) return false;
		if (user.getPassword().isEmpty()) return false;
		if (user.getAddress().isEmpty()) return false;
		return true;
	}

	@Override
	public User validatePassword(String email, String password) throws ServiceException {
		User user;
		
		try {
			user = userDao.findByEmail(email);
		} catch(DAOException ex) {
			LOG.error("Find by email failed!");
			throw new ServiceException("Find by email failed!", ex);
		}
		
		if (user == null) {
			LOG.error("Email or password already exists!");
			return null;
		}
		
		return passwordEncrypter.validatePassword(password, user.getPassword()) ? user : null;
	}

	@Override
	public List<User> findAllUsers() throws ServiceException {
		try {
			return userDao.findAll();
		} catch(DAOException ex) {
			LOG.error("Find all user failed!");
			throw new ServiceException("Find all user failed!", ex);
		}
	}

	@Override
	public User findByEmail(String email) throws ServiceException {
		try {
			return userDao.findByEmail(email);
		} catch(DAOException ex) {
			LOG.error("Find by email failed!");
			throw new ServiceException("Find by email failed!", ex);
		}
	}

}
