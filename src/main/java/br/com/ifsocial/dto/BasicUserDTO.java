package br.com.ifsocial.dto;

import br.com.ifsocial.models.User;

public class BasicUserDTO {

	private Integer id;
	
	private String name;
	
	private String profileImage;
	
	public BasicUserDTO(User user) {
		this.id = user.getId();
		this.name = user.getName();
		this.profileImage = user.getProfileImage().getPath();
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

	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}
	
	
}
