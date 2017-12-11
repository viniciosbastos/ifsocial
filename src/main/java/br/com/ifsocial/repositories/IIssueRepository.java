package br.com.ifsocial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifsocial.models.Issue;

public interface IIssueRepository extends JpaRepository<Issue, Integer>{

	public Issue findById(Integer id);
}
