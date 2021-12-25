package com.clj.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clj.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
