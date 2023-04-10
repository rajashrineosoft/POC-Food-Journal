package com.neosoft.poc.foodjournal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neosoft.poc.foodjournal.entity.Image;
@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {



}
