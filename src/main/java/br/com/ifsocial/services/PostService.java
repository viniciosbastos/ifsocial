package br.com.ifsocial.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifsocial.dto.MessageResponse;
import br.com.ifsocial.dto.PostDTO;
import br.com.ifsocial.dto.ResponseDTO;
import br.com.ifsocial.models.Post;
import br.com.ifsocial.models.User;
import br.com.ifsocial.repositories.IPostRepository;
import br.com.ifsocial.repositories.IUserRepository;

@RestController
@RequestMapping("/post")
public class PostService {
	
	private final IPostRepository postRepository;
	
	private final IUserRepository userRepository;
	
	PostService(IPostRepository postRepository, IUserRepository userRepository) {
		this.postRepository = postRepository;
		this.userRepository = userRepository;
	}

	@RequestMapping(path = "/new", method = RequestMethod.POST)
	public ResponseDTO newPost(@RequestBody PostDTO newPost) {
		User user = userRepository.findById(newPost.getCreator().getId());
		
		Post post = new Post();
		try {
			post.setCreator(user);
			post.setText(newPost.getText());
			post.setCreation(new SimpleDateFormat("dd/MM/yyyy").parse(newPost.getCreation()));
			
			postRepository.save(post);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new ResponseDTO(true, new MessageResponse("Post inserido com sucesso."));
	}
}
