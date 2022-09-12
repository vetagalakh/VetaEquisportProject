package com.vetaequesport.vetaequesportproject.repository;

import com.vetaequesport.vetaequesportproject.entity.Rout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RoutRepository extends JpaRepository<Rout, Integer> {

    @Query(value = "SELECT id_rout, name_rout, desc_rout FROM rout" ,
            nativeQuery = true)
    List<Rout> findAllRouts();




}
