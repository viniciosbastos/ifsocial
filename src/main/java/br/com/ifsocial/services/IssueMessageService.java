package br.com.ifsocial.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifsocial.dto.IssueMessageDTO;
import br.com.ifsocial.dto.MessageResponse;
import br.com.ifsocial.dto.ResponseDTO;
import br.com.ifsocial.models.Issue;
import br.com.ifsocial.models.IssueMessage;
import br.com.ifsocial.models.User;
import br.com.ifsocial.repositories.IIssueMessageRepository;
import br.com.ifsocial.repositories.IIssueRepository;
import br.com.ifsocial.repositories.IUserRepository;

@RestController
@RequestMapping("/group/{groupId}/issues/{issueId}/comments")
public class IssueMessageService {
	
	
	private final IIssueMessageRepository issueMessageRepository;
	private final IIssueRepository issueRepository;
	private final IUserRepository userRepository;
	
	@Autowired
	public IssueMessageService(IIssueMessageRepository issueMessageRepository, IIssueRepository issueRepository, IUserRepository userRepository) {
		this.userRepository = userRepository;
		this.issueMessageRepository = issueMessageRepository;
		this.issueRepository = issueRepository;
	}

	@RequestMapping(path = "/new", method = RequestMethod.POST)
	public ResponseDTO newComment(@PathVariable Integer issueId, @RequestBody IssueMessageDTO newIssueMessage) {
		Issue issue = issueRepository.findById(issueId);
		User user = userRepository.findById(newIssueMessage.getCreator().getId());
		
		IssueMessage issueMessage = new IssueMessage();
		try {
			issueMessage.setCreator(user);
			issueMessage.setIssue(issue);
			issueMessage.setMessage(newIssueMessage.getMessage());
			issueMessage.setCreation(new SimpleDateFormat("dd/MM/yyyy").parse(newIssueMessage.getCreation()));
			
			issueMessageRepository.save(issueMessage);
			this.issueRepository.save(issue);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return new ResponseDTO(true, new MessageResponse("Comentário inserido com sucesso."));
	}
}
