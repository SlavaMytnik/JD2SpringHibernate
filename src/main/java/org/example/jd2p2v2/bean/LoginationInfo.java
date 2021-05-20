package org.example.jd2p2v2.bean;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.stereotype.Component;

import javax.validation.constraints.*;

@Component
public final class LoginationInfo implements Serializable {
	private static final long serialVersionUID = 801841915647308292L;

	@NotNull(message = ValidationAttr.LOGINATION_INFO_ERROR)
	@Size(min = ValidationAttr.VALIDATION_MIN,
			max = ValidationAttr.VALIDATION_MAX,
			message = ValidationAttr.LOGINATION_INFO_ERROR)
	@Pattern(regexp = ValidationAttr.VALIDATION_PATTERN,
			message = ValidationAttr.LOGINATION_INFO_ERROR)
	private String login;

	@NotNull(message = ValidationAttr.LOGINATION_INFO_ERROR)
	@Size(min = ValidationAttr.VALIDATION_MIN,
			max = ValidationAttr.VALIDATION_MAX,
			message = ValidationAttr.LOGINATION_INFO_ERROR)
	@Pattern(regexp = ValidationAttr.VALIDATION_PATTERN,
			message = ValidationAttr.LOGINATION_INFO_ERROR)
	private String password;

	public LoginationInfo() {
		super();
	}

	public LoginationInfo(final String login, final String password) {
		super();

		this.login = login;
		this.password = password;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(final String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		LoginationInfo that = (LoginationInfo) o;
		return Objects.equals(login, that.login) && Objects.equals(password, that.password);
	}

	@Override
	public int hashCode() {
		return Objects.hash(login, password);
	}

	@Override
	public String toString() {
		return "LoginationInfo{" +
				"login='" + login + '\'' +
				", password='" + password + '\'' +
				'}';
	}
}
