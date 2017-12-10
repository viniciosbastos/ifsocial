package br.com.ifsocial.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifsocial.dto.MyGroupsDTO;
import br.com.ifsocial.dto.HomepageInfoDTO;
import br.com.ifsocial.dto.ResponseDTO;
import br.com.ifsocial.repositories.IPostRepository;
import br.com.ifsocial.repositories.IGroupRepository;
import br.com.ifsocial.repositories.IUserRepository;

@RestController
@RequestMapping("/user")
public class UserService {
	
	private final IUserRepository userRepository;
	private final IGroupRepository groupRepository;
	private final IPostRepository postRepository;
	
	@Autowired
	UserService (IUserRepository userRepository, IPostRepository postRepository, IGroupRepository userFollowRepository) {
		this.userRepository = userRepository;
		this.postRepository = postRepository;
		this.groupRepository = userFollowRepository;
	}

	@RequestMapping(path = "/{userId}", method = RequestMethod.GET)
	public ResponseDTO getUsers(@PathVariable Integer userId) {
		HomepageInfoDTO response = new HomepageInfoDTO(postRepository.getFriendsPosts(userId));
		return new ResponseDTO(true, response);
	}
	
	@RequestMapping(path = "/{userId}/groups", method = RequestMethod.GET)
	public ResponseDTO getUserGroups(@PathVariable Integer userId) {
		MyGroupsDTO groupDTO = new MyGroupsDTO();
		groupDTO.setCreatedByFromGroup(userRepository.findById(userId).getGroupsCreated());
		groupDTO.setParticipateFromGroup(groupRepository.getUserGroups(userId));
		return new ResponseDTO(true, groupDTO);
	}

}
