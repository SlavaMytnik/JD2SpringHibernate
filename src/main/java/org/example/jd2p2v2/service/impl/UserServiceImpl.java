package org.example.jd2p2v2.service.impl;

import org.example.jd2p2v2.bean.LoginationInfo;
import org.example.jd2p2v2.bean.RegistrationInfo;
import org.example.jd2p2v2.dao.IUserDAO;
import org.example.jd2p2v2.entity.User;
import org.example.jd2p2v2.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements IUserService {
	private final IUserDAO userDAO;

	@Autowired
	public UserServiceImpl(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Transactional
	public User logination(final LoginationInfo logInfo) {
		return userDAO.logination(logInfo);
	}

	@Transactional
	public User registration(RegistrationInfo regInfo) {
		return userDAO.registration(regInfo);
	}
}
