package br.com.ifsocial.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import br.com.ifsocial.models.Issue;
import br.com.ifsocial.models.IssueMessage;

public class IssueDetailsDTO implements IResponseDTO{
	private IssueDTO issue;

	private Collection<IssueMessageDTO> comments;

	public IssueDetailsDTO(Issue issue, Collection<IssueMessage> issueMessages) {
		this.issue = new IssueDTO(issue);
		if (issueMessages.size() > 0)
			this.comments = convertoIssueToIssueDetailsDTO(issueMessages);
	}

	public IssueDTO getIssue() {
		return issue;
	}

	public void setIssue(IssueDTO issue) {
		this.issue = issue;
	}

	public Collection<IssueMessageDTO> getComments() {
		return comments;
	}

	public void setComments(Collection<IssueMessageDTO> comments) {
		this.comments = comments;
	}

	private Collection<IssueMessageDTO> convertoIssueToIssueDetailsDTO(Collection<IssueMessage> issueMessages) {
		List<IssueMessageDTO> dto = new ArrayList<>();
		
		for (IssueMessage issueMessage : issueMessages) {
			dto.add(new IssueMessageDTO(issueMessage));
		}
		
		return dto;
	}
}
