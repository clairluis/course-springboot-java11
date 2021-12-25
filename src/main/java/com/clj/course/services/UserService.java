package com.clj.course.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.clj.course.entities.User;
import com.clj.course.repositories.UserRepository;
import com.clj.course.services.exceptions.DatabaseException;
import com.clj.course.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> user = repository.findById(id);
		
		return user.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User insert(User user) {
		return repository.save(user);
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException ex) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException ex) {
			throw new DatabaseException(ex.getMessage());
		}
	}
	
	public User update(Long id, User user) {
		try {
			User entity = repository.getOne(id);
			
			updateData(entity, user);
			
			return repository.save(entity);
		} catch (EntityNotFoundException ex) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(User entity, User user) {
		entity.setName(user.getName());
		entity.setEmail(user.getEmail());
		entity.setPhone(user.getPhone());
	}

}
