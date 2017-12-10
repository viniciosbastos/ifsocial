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

@Entity(name = "issue_message")
public class IssueMessage {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "message")
	private String message;
	
	@Column(name = "creation")
	private Date creation;
	
	@ManyToOne
	@JoinColumn(name = "parent")
	private IssueMessage parent;
	
	@JsonIgnore
	@OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
	private Set<IssueMessage> comments = new HashSet<IssueMessage>();
	
	@ManyToOne
	@JoinColumn(name = "issue_id")
	private Issue issue;
	
	@ManyToOne
	@JoinColumn(name = "creator_id")
	private User creator;
	
	public IssueMessage() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getCreation() {
		return creation;
	}

	public void setCreation(Date creation) {
		this.creation = creation;
	}

	public IssueMessage getParent() {
		return parent;
	}

	public void setParent(IssueMessage parent) {
		this.parent = parent;
	}

	public Issue getIssue() {
		return issue;
	}

	public void setIssue(Issue issue) {
		this.issue = issue;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public Set<IssueMessage> getComments() {
		return comments;
	}

	public void setComments(Set<IssueMessage> comments) {
		this.comments = comments;
	}
	
	
}
