package com.apap.tutorial5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apap.tutorial5.model.CarModel;

import java.util.List;

@Repository
public interface CarDb extends JpaRepository<CarModel, Long> {
	CarModel findByType(String type);
}