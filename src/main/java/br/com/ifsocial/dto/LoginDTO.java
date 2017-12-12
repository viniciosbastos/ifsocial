package br.com.ifsocial.dto;

public class LoginDTO {

	private Long registration;

	private String password;

	public LoginDTO() {
	}

	public Long getRegistration() {
		return registration;
	}

	public void setRegistration(Long registration) {
		this.registration = registration;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
