package com.mightyjava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mightyjava.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query("FROM User WHERE email=:email")
	User findByEmail(@Param("email") String email);

	@Transactional
	@Modifying(clearAutomatically=true)
	@Query("Update User t SET t.lastlogindate =:lastlogindate where t.email=:email")
	void logindate(@Param("lastlogindate") String date, @Param("email") String email );

	@Query("SELECT u.name From User u Where u.email=:email ")
	String findByname(@Param("email")String email);
}