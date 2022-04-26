package com.example.async_test.domain.repository;

import com.example.async_test.domain.Building;
import com.example.async_test.domain.Elevator;
import com.example.async_test.domain.enums.LiftType;
import com.example.async_test.domain.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ElevatorRepository extends JpaRepository<Elevator, Long> {
    List<Elevator> findByBuilding(Building building);
    List<Elevator> findByTypeAndStatusAndBuilding(LiftType type, Status status, Building building);
    List<Elevator> findByStatus(Status status);
}
