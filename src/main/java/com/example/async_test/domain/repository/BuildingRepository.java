package com.example.async_test.domain.repository;

import com.example.async_test.domain.Building;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildingRepository extends JpaRepository<Building, Long> {
    Building findByName(String name);
}
