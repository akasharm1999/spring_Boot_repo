package com.bank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.respository.mongo.UserRepository;
import com.bank.model.*;

@Service
public class UserService 
{

	@Autowired
	private UserRepository userRepository;
	
	public  List<UserEntity> getAllUsers()
	{
		return userRepository.findAll();
		
	}
	
	public Optional<UserEntity> getUserById(String id)
	{
		return userRepository.findById(id);
	}
	
	public UserEntity createUser(UserEntity userEntity)
	{
		return userRepository.save(userEntity);
	}
	
	public UserEntity updateUser (String id, UserEntity userDetails)
	{
		
        return userRepository.findById(id).map(user -> {
            user.setName(userDetails.getName());
            user.setAge(userDetails.getAge());
            return userRepository.save(user);
        }).orElse(null);
	}
	
	  public void deleteUser(String id) {
	        userRepository.deleteById(id);
	    }
	
	
}
