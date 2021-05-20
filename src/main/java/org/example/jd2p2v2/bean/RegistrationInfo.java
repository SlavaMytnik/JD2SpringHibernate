package org.example.jd2p2v2.bean;

import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

@Component
public final class RegistrationInfo implements Serializable {
	private static final long serialVersionUID = -4426058126440180400L;

	@NotNull(message = ValidationAttr.REGISTRATION_INFO_ERROR)
	@Size(min = ValidationAttr.VALIDATION_MIN,
			max = ValidationAttr.VALIDATION_MAX,
			message = ValidationAttr.REGISTRATION_INFO_ERROR)
	@Pattern(regexp = ValidationAttr.VALIDATION_PATTERN,
			message = ValidationAttr.REGISTRATION_INFO_ERROR)
	private String login;

	@NotNull(message = ValidationAttr.REGISTRATION_INFO_ERROR)
	@Size(min = ValidationAttr.VALIDATION_MIN,
			max = ValidationAttr.VALIDATION_MAX,
			message = ValidationAttr.REGISTRATION_INFO_ERROR)
	@Pattern(regexp = ValidationAttr.VALIDATION_PATTERN,
			message = ValidationAttr.REGISTRATION_INFO_ERROR)
	private String password;

	@NotNull(message = ValidationAttr.REGISTRATION_INFO_ERROR)
	@Size(min = ValidationAttr.VALIDATION_MIN,
			max = ValidationAttr.VALIDATION_MAX,
			message = ValidationAttr.REGISTRATION_INFO_ERROR)
	@Pattern(regexp = ValidationAttr.VALIDATION_PATTERN,
			message = ValidationAttr.REGISTRATION_INFO_ERROR)
	private String name;

	@NotNull(message = ValidationAttr.REGISTRATION_INFO_ERROR)
	@Size(min = ValidationAttr.VALIDATION_MIN,
			max = ValidationAttr.VALIDATION_MAX,
			message = ValidationAttr.REGISTRATION_INFO_ERROR)
	@Pattern(regexp = ValidationAttr.VALIDATION_PATTERN,
			message = ValidationAttr.REGISTRATION_INFO_ERROR)
	private String surname;

	private String status;
	private String role;

	public RegistrationInfo() {
		super();
	}

	public RegistrationInfo(final String login, final String password,
			final String name, final String surname,
			final String status, final String role) {
		super();

		this.login = login;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.status = status;
		this.role = role;
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

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(final String surname) {
		this.surname = surname;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(final String status) {
		this.status = status;
	}

	public String getRole() {
		return role;
	}

	public void setRole(final String role) {
		this.role = role;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		RegistrationInfo that = (RegistrationInfo) o;
		return Objects.equals(login, that.login)
				&& Objects.equals(password, that.password)
				&& Objects.equals(name, that.name)
				&& Objects.equals(surname, that.surname)
				&& Objects.equals(status, that.status)
				&& Objects.equals(role, that.role);
	}

	@Override
	public int hashCode() {
		return Objects.hash(login, password, name, surname, status, role);
	}

	@Override
	public String toString() {
		return "RegistrationInfo{" +
				"login='" + login + '\'' +
				", password='" + password + '\'' +
				", name='" + name + '\'' +
				", surname='" + surname + '\'' +
				", status='" + status + '\'' +
				", role='" + role + '\'' +
				'}';
	}
}
