package com.apap.tutorial5.repository;

import org.springframework.stereotype.Repository;

import com.apap.tutorial5.model.DealerModel;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface DealerDb extends JpaRepository<DealerModel, Long> {

}