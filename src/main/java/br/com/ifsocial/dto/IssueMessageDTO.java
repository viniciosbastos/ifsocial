package br.com.ifsocial.dto;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import br.com.ifsocial.models.IssueMessage;

public class IssueMessageDTO {

	private Integer id;

	private String message;

	private String creation;

	private CreatorDTO creator;

	private Collection<IssueMessageDTO> responses;

	public IssueMessageDTO(IssueMessage issueMessage) {
		this.id = issueMessage.getId();
		this.message = issueMessage.getMessage();
		this.creation = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(issueMessage.getCreation());
		this.creator = new CreatorDTO(issueMessage.getCreator());
		if (issueMessage.getComments().size() > 0)
			this.responses = convertoIssueToIssueDetailsDTO(issueMessage.getComments());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
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

	public Collection<IssueMessageDTO> getResponses() {
		return responses;
	}

	public void setResponses(Collection<IssueMessageDTO> responses) {
		this.responses = responses;
	}

	private Collection<IssueMessageDTO> convertoIssueToIssueDetailsDTO(Collection<IssueMessage> issueMessages) {
		List<IssueMessageDTO> dto = new ArrayList<>();
		
		for (IssueMessage issueMessage : issueMessages) {
			dto.add(new IssueMessageDTO(issueMessage));
		}
		
		return dto;
	}
}
