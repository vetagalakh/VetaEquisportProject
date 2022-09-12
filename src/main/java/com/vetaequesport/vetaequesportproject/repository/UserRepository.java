package com.vetaequesport.vetaequesportproject.repository;

import com.vetaequesport.vetaequesportproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.OptionalInt;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Modifying
    @Query(value = "INSERT INTO login (login, email, password) VALUES (:login, :email, :password)",
            nativeQuery = true)
    void addUser(@Param("login") String login, @Param("email") String email, @Param("password") String password);

    @Query(value = "SELECT id FROM login WHERE (login=:login) AND (password=:password)", nativeQuery = true)
    Optional<Integer> findUser(@Param("login") String login, @Param("password") String password);

    @Query(value = "SELECT id FROM login WHERE (login=:login)", nativeQuery = true)
    Optional<Integer> checkLogin(@Param("login") String login);

    @Query(value = "SELECT id FROM login WHERE (email=:email)", nativeQuery = true)
    Optional<Integer> checkEmail(@Param("email") String email);

    // @Query(value = "SELECT name, FROM")

}

