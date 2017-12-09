package br.com.ifsocial.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.ifsocial.models.User;

public interface IUserRepository extends JpaRepository<User, Long>{
	
	Collection<User> findById(Integer id);
	
	@Query("select u from user u where u.profile = 3")
	Collection<User> getHomePageInfo();
}
