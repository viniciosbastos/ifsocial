package br.com.ifsocial.dto;

import java.util.ArrayList;
import java.util.Collection;

import br.com.ifsocial.models.Group;
import br.com.ifsocial.models.Issue;

public class GroupDTO implements IResponseDTO {

	private String name;

	private CreatorDTO creator;

	private Integer quantityMembers;

	private Collection<IssueDTO> issues;

	private Integer type;

	public GroupDTO() {
	}

	public GroupDTO(Group group) {
		this.name = group.getName();
		this.creator = new CreatorDTO(group.getCreator());
		this.type = group.getType();

		this.issues = new ArrayList<>();
		for (Issue issue : group.getIssues()) {
			issues.add(new IssueDTO(issue));
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CreatorDTO getCreator() {
		return creator;
	}

	public void setCreator(CreatorDTO creator) {
		this.creator = creator;
	}

	public Integer getQuantityMembers() {
		return quantityMembers;
	}

	public void setQuantityMembers(Integer quantityMembers) {
		this.quantityMembers = quantityMembers;
	}

	public Collection<IssueDTO> getIssues() {
		return issues;
	}

	public void setIssues(Collection<IssueDTO> issues) {
		this.issues = issues;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

}
