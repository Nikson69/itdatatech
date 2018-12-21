package ru.nikson69.dao;

import java.util.List;

import ru.nikson69.model.UserProfile;


public interface UserProfileDao {

	List<UserProfile> findAll();
	
	UserProfile findByType(String type);
	
	UserProfile findById(int id);
}
