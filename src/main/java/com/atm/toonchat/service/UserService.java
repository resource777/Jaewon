package com.atm.toonchat.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.atm.toonchat.domain.User;
import com.atm.toonchat.dto.AddUserRequest;
import com.atm.toonchat.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {
	private final UserRepository userRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	public Long save(AddUserRequest dto){
		return userRepository.save(User.builder()
			.email(dto.getEmail())
			.password(bCryptPasswordEncoder.encode(dto.getPassword()))
			.build()).getId();
	}
}
