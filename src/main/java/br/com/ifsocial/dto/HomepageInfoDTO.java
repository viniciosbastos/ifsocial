package br.com.ifsocial.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import br.com.ifsocial.models.Post;
import br.com.ifsocial.models.User;

public class HomepageInfoDTO implements IResponseDTO {

	private BasicUserDTO user;

	private Collection<PostDTO> posts;

	public HomepageInfoDTO() {
	}

	public HomepageInfoDTO(User user, Collection<Post> posts) {
		this.posts = this.convertPostToPostDTO(posts);
		this.user = new BasicUserDTO(user);
	}

	public Collection<PostDTO> getPosts() {
		return posts;
	}

	public void setPosts(Collection<PostDTO> posts) {
		this.posts = posts;
	}

	public BasicUserDTO getUser() {
		return user;
	}

	public void setUser(BasicUserDTO user) {
		this.user = user;
	}

	private Collection<PostDTO> convertPostToPostDTO(Collection<Post> posts) {
		List<PostDTO> dto = new ArrayList<>();
		for (Post post : posts) {
			dto.add(new PostDTO(post));
		}
		return dto;
	}
}
