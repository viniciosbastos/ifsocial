package br.com.ifsocial.dto;

import br.com.ifsocial.models.User;

public class CreatorDTO {

	private Integer id;

	private String name;

	private String imagePath;

	public CreatorDTO(User user) {
		this.id = user.getId();
		this.name = user.getName();
		this.imagePath = user.getProfileImage().getPath();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

}
