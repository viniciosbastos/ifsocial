package br.com.ifsocial.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import br.com.ifsocial.models.Post;

public class HomepageInfoDTO implements IResponseDTO{
	
	private Collection<PostDTO> posts;

	public HomepageInfoDTO() {}
	
	public HomepageInfoDTO(Collection<Post> posts) {
		this.posts = this.convertPostToPostDTO(posts);		
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
