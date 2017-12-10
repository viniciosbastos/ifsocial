package br.com.ifsocial.dto;

import java.util.Collection;

import br.com.ifsocial.models.Post;

public class HomepageInfoDTO implements IResponseDTO{
	
	private Collection<Post> posts;

	public HomepageInfoDTO() {}

	public Collection<Post> getPosts() {
		return posts;
	}

	public void setPosts(Collection<Post> posts) {
		this.posts = posts;
	}	
}
