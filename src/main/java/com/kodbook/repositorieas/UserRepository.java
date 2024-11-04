package com.kodbook.repositorieas;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodbook.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{


	User findByEmail(String email);

	User findByUsername(String username);

}
