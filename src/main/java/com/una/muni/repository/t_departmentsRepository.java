package com.una.muni.repository;


import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.una.muni.model.TDepartment;
@Repository
public interface t_departmentsRepository extends CrudRepository<TDepartment,String> {
	Optional<TDepartment> findByDepartmentName(String departmentName);

}
