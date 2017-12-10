package br.com.ifsocial.dto;

public class ResponseDTO {
	private Boolean sucess;
	
	private IResponseDTO data;
	
	public ResponseDTO(Boolean sucess, IResponseDTO data) {
		this.sucess = sucess;
		this.data = data;
	}

	public Boolean getSucess() {
		return sucess;
	}

	public void setSucess(Boolean sucess) {
		this.sucess = sucess;
	}

	public IResponseDTO getData() {
		return data;
	}

	public void setData(IResponseDTO data) {
		this.data = data;
	}	
}
