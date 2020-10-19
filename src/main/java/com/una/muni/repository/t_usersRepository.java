package com.una.muni.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import com.una.muni.model.TUser;

@Repository
public interface t_usersRepository extends CrudRepository<TUser , String> {
    // Optional<TUser> findBy
//public interface t_usersRepository extends CrudRepository<t_users , String> {
//	Optional<t_users > findByUser(String user);
}
