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

@Entity(name = "issue")
public class Issue {

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
	
	@ManyToOne
	@JoinColumn(name = "group_id")
	private Group group;
	
	@JsonIgnore
	@OneToMany(mappedBy = "issue", fetch = FetchType.LAZY)	
	private Set<IssueFile> files = new HashSet<IssueFile>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "issue", fetch = FetchType.LAZY)	
	private Set<IssueMessage> messages = new HashSet<IssueMessage>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "issue", fetch = FetchType.LAZY)	
	private Set<FavoriteIssues> favorites = new HashSet<FavoriteIssues>();
	
	public Issue() {}

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

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public Set<IssueFile> getFiles() {
		return files;
	}

	public void setFiles(Set<IssueFile> files) {
		this.files = files;
	}

	public Set<IssueMessage> getMessages() {
		return messages;
	}

	public void setMessages(Set<IssueMessage> messages) {
		this.messages = messages;
	}

	public Set<FavoriteIssues> getFavorites() {
		return favorites;
	}

	public void setFavorites(Set<FavoriteIssues> favorites) {
		this.favorites = favorites;
	}
	
	
}
