package com.una.muni.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.una.muni.entitys.t_requests;
import com.una.muni.model.TRequest;

@Repository
public interface t_requestsRepository extends CrudRepository<TRequest,Integer> {

	
}
