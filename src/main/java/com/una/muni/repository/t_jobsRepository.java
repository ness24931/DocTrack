package com.una.muni.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.una.muni.entitys.t_jobs;
import com.una.muni.model.TJob;
@Repository
public interface t_jobsRepository extends CrudRepository<TJob,Integer>{

}

