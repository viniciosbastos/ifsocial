package br.com.ifsocial.dto;

import java.text.SimpleDateFormat;

import br.com.ifsocial.models.Issue;

public class IssueDTO {

	private String name;

	private Integer id;

	private Integer quantity_comments;

	private String creation;

	private CreatorDTO creator;

	public IssueDTO() {
	}

	public IssueDTO(Issue issue) {
		this.name = issue.getName();
		this.id = issue.getId();
		this.quantity_comments = issue.getMessages().size();
		this.creator = new CreatorDTO(issue.getCreator());
		this.creation = new SimpleDateFormat("dd/MM/yyyy").format(issue.getCreation());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuantity_comments() {
		return quantity_comments;
	}

	public void setQuantity_comments(Integer quantity_comments) {
		this.quantity_comments = quantity_comments;
	}

	public String getCreation() {
		return creation;
	}

	public void setCreation(String creation) {
		this.creation = creation;
	}

	public CreatorDTO getCreator() {
		return creator;
	}

	public void setCreator(CreatorDTO creator) {
		this.creator = creator;
	}

}
