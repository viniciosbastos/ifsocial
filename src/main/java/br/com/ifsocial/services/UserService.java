package br.com.ifsocial.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifsocial.dto.HomepageInfoDTO;
import br.com.ifsocial.dto.IResponseDTO;
import br.com.ifsocial.dto.LoginDTO;
import br.com.ifsocial.dto.MessageResponse;
import br.com.ifsocial.dto.MyGroupsDTO;
import br.com.ifsocial.dto.ProfileDTO;
import br.com.ifsocial.dto.ResponseDTO;
import br.com.ifsocial.models.Post;
import br.com.ifsocial.models.User;
import br.com.ifsocial.repositories.IGroupRepository;
import br.com.ifsocial.repositories.IPostRepository;
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
	public ResponseDTO getUserPosts(@PathVariable Integer userId) {
		User user =  userRepository.findById(userId);
		Collection<Post> posts = postRepository.findByCreatorId(userId);
				
		return new ResponseDTO(true, new ProfileDTO(user, posts));
	}
	
	@RequestMapping(path = "/home/{userId}", method = RequestMethod.GET)
	public ResponseDTO getFriendsPosts(@PathVariable Integer userId) {
		HomepageInfoDTO response = new HomepageInfoDTO(userRepository.findById(userId), postRepository.getFriendsPosts(userId));
		return new ResponseDTO(true, response);
	}
	
	@RequestMapping(path = "/{userId}/groups", method = RequestMethod.GET)
	public ResponseDTO getUserGroups(@PathVariable Integer userId) {
		MyGroupsDTO groupDTO = new MyGroupsDTO();
		groupDTO.setCreatedByFromGroup(userRepository.findById(userId).getGroupsCreated());
		groupDTO.setParticipateFromGroup(groupRepository.getUserGroups(userId));
		return new ResponseDTO(true, groupDTO);
	}
	
	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public ResponseDTO login(@RequestBody LoginDTO loginDTO) {
		User user = userRepository.autenticateUser(loginDTO.getRegistration(), loginDTO.getPassword());
		
		IResponseDTO response = null;
		boolean sucess = false;;
		if (user != null) {
			response = new HomepageInfoDTO(user, postRepository.getFriendsPosts(user.getId()));
		} else {
			response = new MessageResponse("Usuário não encontrado na base de dados.");
		}
		return new ResponseDTO(sucess, response);
	}

}
