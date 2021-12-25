package com.clj.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clj.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
