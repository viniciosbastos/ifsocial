package br.com.ifsocial.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import br.com.ifsocial.models.Issue;
import br.com.ifsocial.models.Post;
import br.com.ifsocial.models.User;

public class HomepageInfoDTO implements IResponseDTO {

	private BasicUserDTO user;

	private Collection<PostDTO> posts;

	private Collection<IssueDTO> favoriteIssues;

	public HomepageInfoDTO() {
	}

	public HomepageInfoDTO(User user, Collection<Post> posts, Collection<Issue> issues) {
		this.posts = this.convertPostToPostDTO(posts);
		this.favoriteIssues = this.convertIssueToIssueDTO(issues);
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

	public Collection<IssueDTO> getFavoriteIssues() {
		return favoriteIssues;
	}

	public void setFavoriteIssues(Collection<IssueDTO> favoriteIssues) {
		this.favoriteIssues = favoriteIssues;
	}

	private Collection<PostDTO> convertPostToPostDTO(Collection<Post> posts) {
		List<PostDTO> dto = new ArrayList<>();
		for (Post post : posts) {
			dto.add(new PostDTO(post));
		}
		return dto;
	}

	private Collection<IssueDTO> convertIssueToIssueDTO(Collection<Issue> issues) {
		List<IssueDTO> dto = new ArrayList<>();
		for (Issue issue : issues) {
			dto.add(new IssueDTO(issue));
		}
		return dto;
	}
}
