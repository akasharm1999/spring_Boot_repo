package com.bank.respository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.bank.model.UserEntity;

public interface UserRepository extends MongoRepository <UserEntity,String>
{
	
}