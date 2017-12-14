package br.com.ifsocial.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifsocial.dto.GroupDTO;
import br.com.ifsocial.dto.MessageResponse;
import br.com.ifsocial.dto.ResponseDTO;
import br.com.ifsocial.models.Group;
import br.com.ifsocial.models.User;
import br.com.ifsocial.repositories.IGroupRepository;
import br.com.ifsocial.repositories.IUserRepository;

@RestController
@RequestMapping("/group")
public class GroupService {

	private final IGroupRepository groupRepository;
	
	private final IUserRepository userRepository;
	
	@Autowired
	GroupService(IGroupRepository groupRepository, IUserRepository userRepository) {
		this.groupRepository = groupRepository;
		this.userRepository = userRepository;
	}
	
	@RequestMapping(path = "/{groupId}", method = RequestMethod.GET)
	public ResponseDTO getGroup(@PathVariable Integer groupId) {
		Group group = groupRepository.findById(groupId);
		GroupDTO groupDTO = new GroupDTO(group);
		groupDTO.setQuantityMembers(groupRepository.getQuantityOfMembers(groupId));
		
		return new ResponseDTO(true, groupDTO);
	}
	
	@RequestMapping(path = "/new", method = RequestMethod.POST)
	public ResponseDTO newGroup(@RequestBody GroupDTO newGroup) {
		Group group = new Group();
		User user = userRepository.findById(newGroup.getCreator().getId());
		
		group.setName(newGroup.getName());
		group.setCreator(user);
		group.setCreation(new Date());
		group.setType(newGroup.getType());
		
		groupRepository.save(group);
		
		return new ResponseDTO(true, new MessageResponse("Grupo criado com sucesso."));
	}
	
}
