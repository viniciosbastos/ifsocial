package br.com.ifsocial.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifsocial.dto.GroupDTO;
import br.com.ifsocial.dto.ResponseDTO;
import br.com.ifsocial.models.Group;
import br.com.ifsocial.repositories.IGroupRepository;

@RestController
@RequestMapping(path = "/group")
public class GroupService {

	private final IGroupRepository groupRepository;
	
	@Autowired
	GroupService(IGroupRepository groupRepository) {
		this.groupRepository = groupRepository;
	}
	
	@RequestMapping(path = "/{groupId}", method = RequestMethod.GET)
	public ResponseDTO getGroup(@PathVariable Integer groupId) {
		Group group = groupRepository.findById(groupId);
		GroupDTO groupDTO = new GroupDTO(group);
		groupDTO.setQuantityMembers(groupRepository.getQuantityOfMembers(groupId));
		
		return new ResponseDTO(true, groupDTO);
	}
}
