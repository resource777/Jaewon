package com.atm.toonchat.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atm.toonchat.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByEmail(String email);
}
