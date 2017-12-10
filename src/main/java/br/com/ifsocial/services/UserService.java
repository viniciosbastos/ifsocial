package br.com.ifsocial.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifsocial.dto.HomepageInfoDTO;
import br.com.ifsocial.dto.ResponseDTO;
import br.com.ifsocial.models.Post;
import br.com.ifsocial.models.User;
import br.com.ifsocial.models.UserFollow;
import br.com.ifsocial.repositories.IPostRepository;
import br.com.ifsocial.repositories.IUserFollowRepository;
import br.com.ifsocial.repositories.IUserRepository;

@RestController
@RequestMapping("/user")
public class UserService {
	
	private final IUserRepository userRepository;
	private final IUserFollowRepository userFollowRepository;
	private final IPostRepository postRepository;
	
	@Autowired
	UserService (IUserRepository userRepository, IPostRepository postRepository, IUserFollowRepository userFollowRepository) {
		this.userRepository = userRepository;
		this.postRepository = postRepository;
		this.userFollowRepository = userFollowRepository;
	}

	@RequestMapping(path="/{userId}/home", method = RequestMethod.GET)
	public ResponseDTO getUsers(@PathVariable Integer userId) {
		HomepageInfoDTO response = new HomepageInfoDTO();
		response.setPosts(postRepository.getFriendsPosts(userId));
		return new ResponseDTO(true, response);
	}

}
