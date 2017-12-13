package br.com.ifsocial.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifsocial.dto.IssueDTO;
import br.com.ifsocial.dto.IssueDetailsDTO;
import br.com.ifsocial.dto.MessageResponse;
import br.com.ifsocial.dto.ResponseDTO;
import br.com.ifsocial.models.FavoriteIssues;
import br.com.ifsocial.models.Group;
import br.com.ifsocial.models.Issue;
import br.com.ifsocial.models.User;
import br.com.ifsocial.repositories.IFavoriteIssueRepository;
import br.com.ifsocial.repositories.IGroupRepository;
import br.com.ifsocial.repositories.IIssueMessageRepository;
import br.com.ifsocial.repositories.IIssueRepository;
import br.com.ifsocial.repositories.IUserRepository;

@RestController
@RequestMapping("/group/{groupId}/issues")
public class IssueService {

	private final IIssueRepository issueRepository;
	private final IIssueMessageRepository issueMessageRepository;
	private final IGroupRepository groupRepositry;
	private final IUserRepository userRepositry;
	private final IFavoriteIssueRepository favoriteIssueRepositry;
	
	@Autowired
	IssueService(IIssueRepository issueRepository, 
				 IIssueMessageRepository issueMessageRepository, 
				 IGroupRepository groupRepository, 
				 IUserRepository userRepository,
				 IFavoriteIssueRepository favoriteIssueRepositry) {
		this.issueRepository = issueRepository;
		this.issueMessageRepository = issueMessageRepository;
		this.groupRepositry = groupRepository;
		this.userRepositry = userRepository;
		this.favoriteIssueRepositry = favoriteIssueRepositry;
	}

	@RequestMapping(path = "/{issueId}", method = RequestMethod.GET)
	public ResponseDTO getIssue(@PathVariable Integer issueId) {
		Issue issue = issueRepository.findById(issueId);
		IssueDetailsDTO issueDetails = new IssueDetailsDTO(issue, issueMessageRepository.getComments(issueId));
		
		return new ResponseDTO(true, issueDetails);
	}
	
	@RequestMapping(path = "/{issueId}/favorite", method = RequestMethod.GET)
	public ResponseDTO favoriteIssue(@PathVariable Integer issueId, @RequestParam("userId") Integer userId) {
		Issue issue = issueRepository.findById(issueId);
		User user = userRepositry.findById(userId);
		
		FavoriteIssues favorite = new FavoriteIssues();
		favorite.setIssue(issue);
		favorite.setUser(user);
		
		favoriteIssueRepositry.save(favorite);
		
		return new ResponseDTO(true, new MessageResponse("Issue favoritada com sucesso."));
	}
	
	@RequestMapping(path = "/new", method = RequestMethod.POST)
	public ResponseDTO newIssue(@PathVariable Integer groupId, @RequestBody IssueDTO newIssue) {
		Group group = groupRepositry.findById(groupId) ;
		User user = userRepositry.findById(newIssue.getCreator().getId());
		
		Issue issue = new Issue();
		try {
			issue.setName(newIssue.getName());
			issue.setCreation(new SimpleDateFormat("dd/MM/yyyy").parse(newIssue.getCreation()));
			issue.setGroup(group);
			issue.setCreator(user);
			
			this.issueRepository.save(issue);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new ResponseDTO(true, new MessageResponse("Issue inserida com sucesso."));
	}
}
