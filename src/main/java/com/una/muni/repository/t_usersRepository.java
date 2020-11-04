package com.una.muni.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import com.una.muni.model.TUser;

@Repository
public interface t_usersRepository extends CrudRepository<TUser, String> {
    // @Modifying
    @Query("update t_users u set u.USERNAME = :username where u.USERNAME = :oldUserName")
    void updateUserName(@Param(value = "username") String username, @Param(value = "oldUserName") String oldUserName);
    // Optional<TUser> findBy
    // public interface t_usersRepository extends CrudRepository<t_users , String> {
    // Optional<t_users > findByUser(String user);
}
