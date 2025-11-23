package com.ulises.MuseumAtHome.repository;

import com.ulises.MuseumAtHome.entity.Work;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkRepository extends JpaRepository<Work, Long> {

    List<Work> searchByName(String name);

    List<Work> findByNameContaining(String name);

    List<Work> findByPriceLessThanEqual(Double price);

}
