package br.com.ifsocial.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.ifsocial.models.Group;
import br.com.ifsocial.models.UserFollow;

public interface IGroupRepository extends JpaRepository<Group, Integer>{

	@Query("select u.group from user_group u where u.user.id = :userId")
	public Collection<Group> getUserGroups(@Param("userId") Integer userId);
		
}
