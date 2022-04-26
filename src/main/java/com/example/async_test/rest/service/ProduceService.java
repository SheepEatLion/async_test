package com.example.async_test.rest.service;

import com.example.async_test.domain.Building;
import com.example.async_test.domain.Elevator;
import com.example.async_test.domain.repository.BuildingRepository;
import com.example.async_test.domain.repository.ElevatorRepository;
import com.example.async_test.util.dto.CreateElevatorReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProduceService {

    private final BuildingRepository buildingRepository;
    private final ElevatorRepository elevatorRepository;

    public void createBuilding(String name){
        Building building = Building.building(name);
        buildingRepository.save(building);
    }

    public void createElevator(CreateElevatorReq elevatorReq){
        Building building = buildingRepository.findByName(elevatorReq.getBuildingName());
        Elevator elevator = Elevator.elevator(elevatorReq.getLiftType(), elevatorReq.getMinRange(), elevatorReq.getMaxRange(), building);
        elevatorRepository.save(elevator);
    }
}
