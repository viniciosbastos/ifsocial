package br.com.ifsocial.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.ifsocial.models.User;
import br.com.ifsocial.models.UserFollow;

public interface IUserFollowRepository extends JpaRepository<UserFollow, Integer>{

	@Query("select u.followed from user_follow u where u.user.id = :userId")
	public Collection<User> getFollowing(@Param("userId") Integer userId);
}
