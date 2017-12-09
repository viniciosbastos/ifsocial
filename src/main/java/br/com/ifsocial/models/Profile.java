package br.com.ifsocial.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="profile")
public class Profile {

	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id;
	
	@Column(name="description")
	private String description;
	
	@JsonIgnore
	@OneToMany(mappedBy="profile")
	private Set<User> users = new HashSet<User>();
	
	public Profile() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	};
		
}
