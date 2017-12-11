package br.com.ifsocial.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import br.com.ifsocial.models.Post;
import br.com.ifsocial.models.User;

public class ProfileDTO implements IResponseDTO {

	private User userData;

	private Collection<PostDTO> posts;

	public ProfileDTO(User user, Collection<Post> posts) {
		this.userData = user;
		this.posts = convertPostToPostDTO(posts);
	}

	public User getUserData() {
		return userData;
	}

	public void setUserData(User userData) {
		this.userData = userData;
	}

	public Collection<PostDTO> getPosts() {
		return posts;
	}

	public void setPosts(Collection<PostDTO> posts) {
		this.posts = posts;
	}

	private Collection<PostDTO> convertPostToPostDTO(Collection<Post> posts) {
		List<PostDTO> dto = new ArrayList<>();
		for (Post post : posts) {
			dto.add(new PostDTO(post));
		}
		return dto;
	}
}
