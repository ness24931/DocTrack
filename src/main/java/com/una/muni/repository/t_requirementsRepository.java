package com.una.muni.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.una.muni.model.TRequirement;

@Repository
public interface t_requirementsRepository extends CrudRepository<TRequirement,Integer> {

}
