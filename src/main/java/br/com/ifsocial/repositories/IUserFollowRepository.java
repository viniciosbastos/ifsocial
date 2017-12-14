package br.com.ifsocial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifsocial.models.UserFollow;

public interface IUserFollowRepository extends JpaRepository<UserFollow, Integer>{

}
