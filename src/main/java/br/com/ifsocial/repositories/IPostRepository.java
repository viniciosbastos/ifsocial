package br.com.ifsocial.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.ifsocial.models.Post;

public interface IPostRepository extends JpaRepository<Post, Integer>{
	
	@Query("select p from post p where p.creator in (select u.followed from user_follow u where u.user.id = :userId) order by p.creation desc")
	public Collection<Post> getFriendsPosts(@Param("userId") Integer userId);
}
