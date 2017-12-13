package br.com.ifsocial.dto;

import java.util.Collection;

public class SearchUserResponse implements IResponseDTO {

	private Collection<BasicUserDTO> users;

	public SearchUserResponse(Collection<BasicUserDTO> users) {
		this.users = users;
	}

	public Collection<BasicUserDTO> getUsers() {
		return users;
	}

	public void setUsers(Collection<BasicUserDTO> users) {
		this.users = users;
	}

}
