package com.vetaequesport.vetaequesportproject.repository;

import com.vetaequesport.vetaequesportproject.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Integer> {
    @Modifying
    @Query(value = "INSERT INTO application (name_participant, horse_name, rang, year_of_birth) VALUES (:name_participant, :horse_name, :rang, :year_of_birth)",
            nativeQuery = true)
    void addParticipant(@Param("name_participant") String name_participant, @Param("horse_name") String horse_name, @Param("rang") String rang, @Param("year_of_birth") String year_of_birth);

    @Query(value = "SELECT id, name_participant, horse_name, rang, year_of_birth FROM application WHERE rang= :rang",
            nativeQuery = true)
    List<Application> findByRang(@Param("rang") int rang);

}




