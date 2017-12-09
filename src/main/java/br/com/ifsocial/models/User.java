package br.com.ifsocial.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "user")
public class User {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;

	@Column(name = "registration")
	private Long registration;

	@Column(name = "name")
	private String name;

	@JsonIgnore
	@Column(name = "password")
	private String password;

	@Column(name = "address")
	private String address;

	@Column(name = "interests")
	private String interests;

	@Column(name = "email")
	private String email;

	@Column(name = "dt_birth")
	private Date birthday;

	@JsonIgnore
	@ManyToOne
	private Profile profile;

	public User() {
	};

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getInterests() {
		return interests;
	}

	public void setInterests(String interests) {
		this.interests = interests;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

}
