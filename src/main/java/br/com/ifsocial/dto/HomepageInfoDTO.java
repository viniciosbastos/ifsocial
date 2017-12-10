package br.com.ifsocial.dto;

import java.util.ArrayList;
import java.util.Collection;

import br.com.ifsocial.models.Post;

public class HomepageInfoDTO implements IResponseDTO{
	
	private Collection<PostDTO> posts;

	public HomepageInfoDTO() {}
	
	public HomepageInfoDTO(Collection<Post> posts) {
		this.posts = new ArrayList<>();
		this.convertPostToPostDTO(posts);
	}

	public Collection<PostDTO> getPosts() {
		return posts;
	}

	public void setPosts(Collection<PostDTO> posts) {
		this.posts = posts;
	}	
	
	private void convertPostToPostDTO(Collection<Post> posts) {
		for (Post post : posts) {
			this.posts.add(new PostDTO(post));
		}
	}
}
