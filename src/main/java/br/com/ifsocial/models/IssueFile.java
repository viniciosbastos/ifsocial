package br.com.ifsocial.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "issue_file")
public class IssueFile {

	@Id
	@GeneratedValue
	@Column(name = "id")
	public Integer id;
	
	@OneToOne
	@JoinColumn(name = "file_id")
	public File file;
	
	@OneToOne
	@JoinColumn(name = "issue_id")
	public Issue issue;
	
	public IssueFile() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public Issue getIssue() {
		return issue;
	}

	public void setIssue(Issue issue) {
		this.issue = issue;
	}
	
	
}
