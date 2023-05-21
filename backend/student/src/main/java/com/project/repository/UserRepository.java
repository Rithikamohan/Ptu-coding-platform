package com.project.repository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.domain.User;
import org.springframework.transaction.annotation.Transactional;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query("FROM User WHERE email=:email")
	User findByEmail(@Param("email") String email);
	
	@Transactional
	@Modifying(clearAutomatically=true)
	@Query("Update User t SET t.lastlogindate =:lastlogindate where t.email=:email")
	void logindate(@Param("lastlogindate") String date, @Param("email") String email );
	

	@Query(value="FROM User u Where u.faculty=:faculty ")
	List<User> findByname(@Param("faculty")String faculty);
	
	
	@Query(value="SELECT u.name FROM User u")
	ArrayList[] findAllname();
	
	@Query(value="SELECT u.points FROM User u")
	ArrayList[] findAllpoints();
	
	
	@Transactional
	@Modifying(clearAutomatically=true)
	@Query("Update User t SET t.points =:points where t.name=:name")
	void setMark(@Param("points") int points, @Param("name") String name );
	
	
	@Query("SELECT u.name From User u Where u.email=:email ")
	String findBysname(@Param("email")String email);
	
	@Query("SELECT t.points FROM User t WHERE t.name=:name ")
	int getMark(@Param("name") String name );
	
	
	//set c total mark
	@Transactional
	@Modifying(clearAutomatically=true)
	@Query("Update User t SET t.c =:c where t.name=:name")
	void setC(@Param("c") int c, @Param("name") String name );
		
	@Query("SELECT t.c FROM User t WHERE t.name=:name ")
	int getC(@Param("name") String name );

	
	    //c basic
		@Transactional
		@Modifying(clearAutomatically=true)
		@Query("Update User t SET t.cbasic =:cbasic where t.name=:name")
		void setCbasic(@Param("cbasic") int cplus, @Param("name") String name );
			
		
		@Query("SELECT t.cbasic FROM User t WHERE t.name=:name ")
		int getCbasic(@Param("name") String name );
		

		//c inter
		
		@Transactional
		@Modifying(clearAutomatically=true)
		@Query("Update User t SET t.cinter =:cinter where t.name=:name")
		void setCinter(@Param("cinter") int cplus, @Param("name") String name );
			
		
		@Query("SELECT t.cinter FROM User t WHERE t.name=:name ")
		int getCinter(@Param("name") String name );
		
		
		//cadv
		
		@Transactional
		@Modifying(clearAutomatically=true)
		@Query("Update User t SET t.cadv =:cadv where t.name=:name")
		void setCadv(@Param("cadv") int cplus, @Param("name") String name );
						
		@Query("SELECT t.cadv FROM User t WHERE t.name=:name ")
		int getCadv(@Param("name") String name );
	
	//c plus
	@Transactional
	@Modifying(clearAutomatically=true)
	@Query("Update User t SET t.cplus =:cplus where t.name=:name")
	void setCplus(@Param("cplus") int cplus, @Param("name") String name );
		
	
	@Query("SELECT t.cplus FROM User t WHERE t.name=:name ")
	int getCplus(@Param("name") String name );
	
	
	
	
	
	
	}