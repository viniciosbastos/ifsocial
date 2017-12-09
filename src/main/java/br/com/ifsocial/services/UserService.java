package br.com.ifsocial.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifsocial.models.User;
import br.com.ifsocial.repositories.IUserRepository;

@RestController
@RequestMapping("/user/{userId}")
public class UserService {
	
	private final IUserRepository userRepository;
	
	@Autowired
	UserService (IUserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@RequestMapping(method = RequestMethod.GET)
	public Collection<User> getUsers(@PathVariable Integer userId) {
		return this.userRepository.findById(userId);
	}
}
