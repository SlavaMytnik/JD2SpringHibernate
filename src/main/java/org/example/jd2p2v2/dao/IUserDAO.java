package org.example.jd2p2v2.dao;

import org.example.jd2p2v2.bean.LoginationInfo;
import org.example.jd2p2v2.bean.RegistrationInfo;
import org.example.jd2p2v2.entity.User;

public interface IUserDAO {
	User logination(LoginationInfo logInfo);
	User registration(RegistrationInfo regInfo);
}
