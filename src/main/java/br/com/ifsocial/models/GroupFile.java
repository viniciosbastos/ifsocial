package br.com.ifsocial.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "group_file")
public class GroupFile {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;

	@OneToOne
	@JoinColumn(name = "file_id")
	private File file;
	
	@OneToOne
	@JoinColumn(name = "group_id")
	private Group group;
	
	public GroupFile() {}

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

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}	
}
