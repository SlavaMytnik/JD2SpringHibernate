package org.example.jd2p2v2.dao.impl;

import org.example.jd2p2v2.bean.LoginationInfo;
import org.example.jd2p2v2.bean.RegistrationInfo;
import org.example.jd2p2v2.dao.DAOAttr;
import org.example.jd2p2v2.dao.IUserDAO;
import org.example.jd2p2v2.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SQLUserDAO implements IUserDAO {
	private final SessionFactory sessionFactory;

	@Autowired
	public SQLUserDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public User logination(LoginationInfo logInfo) {
		Session currentSession = sessionFactory.getCurrentSession();

		User user = currentSession.get(User.class, logInfo.getLogin());

		if (user == null
				|| !user.getPassword().equals(logInfo.getPassword())
				|| !user.getStatus().equals(DAOAttr.STATUS_ACTIVE)) {
			return null;
		}

		return user;
	}

	@Override
	public User registration(RegistrationInfo regInfo) {
		Session currentSession = sessionFactory.getCurrentSession();

		User user = currentSession.get(User.class, regInfo.getLogin());

		if (user != null) {
			return null;
		}

		user = new User(regInfo.getLogin(), regInfo.getPassword(),
				regInfo.getName(), regInfo.getSurname(),
				regInfo.getStatus(), regInfo.getRole());

		currentSession.save(user);

		return user;
	}
}
