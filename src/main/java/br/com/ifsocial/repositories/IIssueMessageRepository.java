package br.com.ifsocial.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.ifsocial.models.IssueMessage;

public interface IIssueMessageRepository extends JpaRepository<IssueMessage, Integer>{

	@Query("select im from issue_message im where im.issue.id = :issueId and im.parent is null order by im.creation desc")
	public Collection<IssueMessage> getComments(@Param("issueId") Integer issueId);

	public IssueMessage findById(Integer commentId);
}
