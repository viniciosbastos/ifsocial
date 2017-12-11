package br.com.ifsocial.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifsocial.dto.IssueDetailsDTO;
import br.com.ifsocial.dto.ResponseDTO;
import br.com.ifsocial.models.Issue;
import br.com.ifsocial.repositories.IIssueMessageRepository;
import br.com.ifsocial.repositories.IIssueRepository;

@RestController
@RequestMapping("/issues")
public class IssueService {

	private final IIssueRepository issueRepository;
	private final IIssueMessageRepository issueMessageRepository;
	
	@Autowired
	IssueService(IIssueRepository issueRepository, IIssueMessageRepository issueMessageRepository) {
		this.issueRepository = issueRepository;
		this.issueMessageRepository = issueMessageRepository;
	}

	@RequestMapping(path = "/{issueId}", method = RequestMethod.GET)
	public ResponseDTO getIssue(@PathVariable Integer issueId) {
		Issue issue = issueRepository.findById(issueId);
		IssueDetailsDTO issueDetails = new IssueDetailsDTO(issue, issueMessageRepository.getComments(issueId));
		
		return new ResponseDTO(true, issueDetails);
	}
}
