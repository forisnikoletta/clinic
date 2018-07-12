package edu.wk.clinic.dao.jpa;


import edu.wk.clinic.dao.DAOException;
import edu.wk.clinic.dao.UserDAO;
import edu.wk.clinic.model.User;

import javax.ejb.Stateless;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import java.util.List;


@Stateless
public class UserJpaDAO extends JpaDAO<User> implements UserDAO {

	public UserJpaDAO() {
		super(User.class);
	}

	@Override
	public User findByEmail(String email) {
		TypedQuery<User> query = entityManager.createNamedQuery(User.QUERY_FIND_BY_EMAIL, User.class);
		query.setParameter("email", email);
		
		try {
			List<User> users = query.getResultList();
			if (users.isEmpty()) {
				return null;
			}
			return users.get(0);
		} catch(PersistenceException ex) {
			throw new DAOException("User JPA Connection error!", ex);
		}
	}

}
