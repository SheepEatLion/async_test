package com.example.async_test.domain.repository;

import com.example.async_test.domain.Elevator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElevatorRepository extends JpaRepository<Elevator, Long> {
}
