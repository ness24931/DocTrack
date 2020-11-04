package com.una.muni.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import com.una.muni.model.TEmployee;

@Repository
public interface t_employeesRepository extends CrudRepository<TEmployee, Integer> {
    Iterable<TEmployee> findAllByFirstName(String firstName);

    Optional<TEmployee> findByDni(String employeeId);
}
