package com.vetaequesport.vetaequesportproject.repository;

import com.vetaequesport.vetaequesportproject.entity.Participant;
import com.vetaequesport.vetaequesportproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Integer> {
    @Modifying
    @Query(value = "INSERT INTO application (name_participant, horse_name, rang, year_of_birth) VALUES (:name_participant, :horse_name, :rang, :year_of_birth)",
            nativeQuery = true)
    @Transactional
    void addParticipant(@Param("name_participant") String name_participant, @Param("horse_name") String horse_name, @Param("rang") String rang, @Param("year_of_birth") String year_of_birth);
}

