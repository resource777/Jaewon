package com.atm.toonchat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.atm.toonchat.dto.AddUserRequest;
import com.atm.toonchat.service.UserDetailService;
import com.atm.toonchat.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserApiController {

	private final UserService userService;

	@PostMapping("/user")
	public String signup(AddUserRequest request){
		userService.save(request);
		return "redirect:/login";
	}
}
