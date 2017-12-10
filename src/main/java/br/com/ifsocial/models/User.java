package br.com.ifsocial.models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
	@JoinColumn(name = "profile_id")
	private Profile profile;

	@JsonIgnore
	@OneToMany(mappedBy = "creator", fetch = FetchType.LAZY)
	private Set<Group> groupsCreated = new HashSet<Group>();

	@JsonIgnore
	@OneToMany(mappedBy = "creator", fetch = FetchType.LAZY)
	private Set<Issue> issuesCreated = new HashSet<Issue>();

	@JsonIgnore
	@OneToMany(mappedBy = "creator", fetch = FetchType.LAZY)
	private Set<IssueMessage> comments = new HashSet<IssueMessage>();

	@JsonIgnore
	@OneToMany(mappedBy = "creator", fetch = FetchType.LAZY)
	private Set<Post> posts = new HashSet<Post>();

	@JsonIgnore
	@OneToMany(mappedBy = "receiver", fetch = FetchType.LAZY)
	private Set<PrivateMessage> messagesReceived = new HashSet<PrivateMessage>();

	@JsonIgnore
	@OneToMany(mappedBy = "sender", fetch = FetchType.LAZY)
	private Set<PrivateMessage> messagesSent = new HashSet<PrivateMessage>();

	@JsonIgnore
	@OneToMany(mappedBy = "followed", fetch = FetchType.LAZY)
	private Set<Issue> followers = new HashSet<Issue>();

	@JsonIgnore
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private Set<Issue> following = new HashSet<Issue>();

	public User() {
	}

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

	public Long getRegistration() {
		return registration;
	}

	public void setRegistration(Long registration) {
		this.registration = registration;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}	
}
