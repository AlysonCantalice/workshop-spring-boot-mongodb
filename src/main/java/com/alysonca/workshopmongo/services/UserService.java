package com.alysonca.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alysonca.workshopmongo.domain.User;
import com.alysonca.workshopmongo.dto.UserDTO;
import com.alysonca.workshopmongo.repository.UserRepository;
import com.alysonca.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	public List<User> findAll() {
		return repo.findAll();
	}

	public User findById(String id) {
		Optional<User> user = repo.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Object not found!"));
	}

	public User insert(User obj) {
		return repo.insert(obj);
	}

	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}

	public User update(User obj) {
		Optional<User> newObj = repo.findById(obj.getId());
		updateData(newObj.orElseThrow(() -> new ObjectNotFoundException("Object not found!")), obj);
		return repo.save(newObj.orElseThrow(() -> new ObjectNotFoundException("Object not found!")));
	}

	public void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}
	
	public User fromDTO(UserDTO obj) {
		return new User(obj.getId(), obj.getName(), obj.getEmail());
	}

}
