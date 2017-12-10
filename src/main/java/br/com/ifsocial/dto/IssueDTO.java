package br.com.ifsocial.dto;

import br.com.ifsocial.models.Issue;

public class IssueDTO {
	
	private String name;
	
	private Integer id;
	
	private Integer quantity_comments;
	
	public IssueDTO() {} 
	
	public IssueDTO(Issue issue) {
		this.name = issue.getName();
		this.id = issue.getId();
		this.quantity_comments = issue.getMessages().size();
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

}
