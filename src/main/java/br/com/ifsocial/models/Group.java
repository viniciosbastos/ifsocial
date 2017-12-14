package br.com.ifsocial.models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "groups")
public class Group {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "dt_creation")
	private Date creation;

	@ManyToOne
	@JoinColumn(name = "creator_id")
	private User creator;

	@Column(name = "type")
	private Integer type;

	@JsonIgnore
	@OneToMany(mappedBy = "group", fetch = FetchType.LAZY)
	private Set<GroupFile> files = new HashSet<GroupFile>();

	@JsonIgnore
	@OneToMany(mappedBy = "group", fetch = FetchType.LAZY)
	private Set<Issue> issues = new HashSet<Issue>();

	public Group() {
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

	public Date getCreation() {
		return creation;
	}

	public void setCreation(Date creation) {
		this.creation = creation;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public Set<GroupFile> getFiles() {
		return files;
	}

	public void setFiles(Set<GroupFile> files) {
		this.files = files;
	}

	public Set<Issue> getIssues() {
		return issues;
	}

	public void setIssues(Set<Issue> issues) {
		this.issues = issues;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

}
