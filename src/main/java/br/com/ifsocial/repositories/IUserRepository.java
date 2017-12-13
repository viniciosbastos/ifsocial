package br.com.ifsocial.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.ifsocial.dto.BasicUserDTO;
import br.com.ifsocial.models.User;

public interface IUserRepository extends JpaRepository<User, Long>{
	
	User findById(Integer id);
	
	@Query("select u from user u where u.profile = 3")
	Collection<User> getHomePageInfo();
	
	@Query("select u from user u where u.registration = :registration and upper(u.password) = upper(:password)")
	User autenticateUser(@Param("registration") Long registration, @Param("password") String password);
	
	@Query("select new br.com.ifsocial.dto.BasicUserDTO(u.id, u.name, u.profileImage.path) from user u where upper(u.name) like '%'||upper(:name)||'%' and u.profile.id <> 1")
	Collection<BasicUserDTO> searchUserByName(@Param("name") String name);
}
