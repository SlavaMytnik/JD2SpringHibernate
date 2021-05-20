package org.example.jd2p2v2.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = EntityAttr.TABLE_USERS)
public final class User implements Serializable {
	private static final long serialVersionUID = -3939656004423001506L;

	@Id
	@Column(name = EntityAttr.LOGIN)
	private String login;
	
	@Column(name = EntityAttr.PASSWORD)
	private String password;
	
	@Column(name = EntityAttr.NAME)
	private String name;
	
	@Column(name = EntityAttr.SURNAME)
	private String surname;

	@Column(name = EntityAttr.STATUS)
	private String status;

	@Column(name = EntityAttr.ROLE)
	private String role;

	public User() {
		super();
	}

	public User(final String login, final String password,
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

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		User user = (User) o;
		return Objects.equals(login, user.login)
				&& Objects.equals(password, user.password)
				&& Objects.equals(name, user.name)
				&& Objects.equals(surname, user.surname)
				&& Objects.equals(status, user.status)
				&& Objects.equals(role, user.role);
	}

	@Override
	public int hashCode() {
		return Objects.hash(login, password, name, surname, status, role);
	}

	@Override
	public String toString() {
		return "User{" +
				"login='" + login + '\'' +
				", password='" + password + '\'' +
				", name='" + name + '\'' +
				", surname='" + surname + '\'' +
				", status='" + status + '\'' +
				", role='" + role + '\'' +
				'}';
	}
}
