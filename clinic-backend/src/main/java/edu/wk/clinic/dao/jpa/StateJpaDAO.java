package edu.wk.clinic.dao.jpa;


import edu.wk.clinic.dao.StateDAO;
import edu.wk.clinic.model.State;

import javax.ejb.Stateless;

@Stateless
public class StateJpaDAO extends JpaDAO<State> implements StateDAO
{

	public StateJpaDAO() {
		super(State.class);
	}

}
