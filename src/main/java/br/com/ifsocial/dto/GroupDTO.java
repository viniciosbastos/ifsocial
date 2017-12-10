package br.com.ifsocial.dto;

import java.util.Collection;

import br.com.ifsocial.models.Group;

public class GroupDTO implements IResponseDTO{

	private Collection<Group> createdBy;
	
	private Collection<Group> participate;
	
	public GroupDTO() {		
	}
	
	public GroupDTO(Collection<Group> groups) {
		this.createdBy = groups;
	}
	
	public Collection<Group> getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Collection<Group> createdBy) {
		this.createdBy = createdBy;
	}

	public Collection<Group> getParticipate() {
		return participate;
	}

	public void setParticipate(Collection<Group> participate) {
		this.participate = participate;
	}
	
	
}
