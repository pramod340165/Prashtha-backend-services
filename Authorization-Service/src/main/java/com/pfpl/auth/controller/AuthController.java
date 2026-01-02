package com.pfpl.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pfpl.auth.config.JwtUtil;
import com.pfpl.auth.entity.User;

	@RestController
	@RequestMapping("/auth")
	public class AuthController {

	    @Autowired
	    JwtUtil jwtUtil;

	    @PostMapping("/login")
	    public String login(@RequestBody User request) {
	        // Dummy validation (replace with DB)
	        if ("user".equals(request.getUsername()) &&
	            "password".equals(request.getPassword())) {
	            return jwtUtil.generateToken(request.getUsername());
	        }
	        throw new RuntimeException("Invalid credentials");
	    }
	}



