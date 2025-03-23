package com.bank.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;  



import com.bank.model.UserEntity;
import com.bank.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	public List<UserEntity> getAllUsers() {
		return userService.getAllUsers();
	}

	// Create a new user
	@PostMapping
	public UserEntity createUser(@RequestBody UserEntity user) {
		return userService.createUser(user);
	}

	@GetMapping("/{id}") // <-- THIS IS REQUIRED
	public Optional<UserEntity> getUserById(@PathVariable String id) {
		return userService.getUserById(id);
	}

	// Update a user
	@PutMapping("/{id}")
	public UserEntity updateUser(@PathVariable String id, @RequestBody UserEntity userDetails) {
		return userService.updateUser(id, userDetails);
	}

	// Delete a user
	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable String id) {
		userService.deleteUser(id);
		return "User deleted successfully!";
	}

}
