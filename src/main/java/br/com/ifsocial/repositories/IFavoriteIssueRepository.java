package br.com.ifsocial.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.ifsocial.models.FavoriteIssues;
import br.com.ifsocial.models.Issue;

public interface IFavoriteIssueRepository extends JpaRepository<FavoriteIssues, Integer> {

	@Query("select fi.issue from favorite_issues fi where fi.user.id = :userId")
	public Collection<Issue> getFavoriteByUser(@Param("userId") Integer userId);
}
