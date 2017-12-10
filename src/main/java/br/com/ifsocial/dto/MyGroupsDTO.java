package br.com.ifsocial.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import br.com.ifsocial.models.Group;

public class MyGroupsDTO implements IResponseDTO {

	private Collection<GroupDTO> createdBy;

	private Collection<GroupDTO> participate;

	public MyGroupsDTO() {
	}

	public MyGroupsDTO(Collection<Group> createdBy, Collection<Group> participate) {
		this.createdBy = this.convertGroupToGrouptDTO(createdBy);
		this.participate = this.convertGroupToGrouptDTO(participate);
	}

	public void setCreatedByFromGroup(Set<Group> groupsCreated) {
		this.setCreatedBy(this.convertGroupToGrouptDTO(groupsCreated));
	}

	public void setParticipateFromGroup(Collection<Group> userGroups) {
		this.setParticipate(this.convertGroupToGrouptDTO(userGroups));
	}
	
	public Collection<GroupDTO> getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Collection<GroupDTO> createdBy) {
		this.createdBy = createdBy;
	}

	public Collection<GroupDTO> getParticipate() {
		return participate;
	}

	public void setParticipate(Collection<GroupDTO> participate) {
		this.participate = participate;
	}

	private List<GroupDTO> convertGroupToGrouptDTO(Collection<Group> groups) {
		List<GroupDTO> dto = new ArrayList<>();
		for (Group group : groups) {
			dto.add(new GroupDTO(group));
		}
		
		return dto;
	}

}
