package br.com.ifsocial.dto;

import java.text.SimpleDateFormat;

import br.com.ifsocial.models.Post;

public class PostDTO {

	private Integer id;

	private String text;

	private String creation;

	private CreatorDTO creator;

	public PostDTO(Post post) {
		this.id = post.getId();
		this.text = post.getText();
		this.creation = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(post.getCreation());
		this.creator = new CreatorDTO(post.getCreator());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getCreation() {
		return creation;
	}

	public void setCreation(String creation) {
		this.creation = creation;
	}

	public CreatorDTO getCreator() {
		return creator;
	}

	public void setCreator(CreatorDTO creator) {
		this.creator = creator;
	}
}
