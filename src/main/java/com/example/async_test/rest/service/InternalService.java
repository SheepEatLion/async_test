package com.example.async_test.rest.service;

import com.example.async_test.domain.Elevator;
import com.example.async_test.domain.enums.State;
import com.example.async_test.domain.enums.Status;
import com.example.async_test.domain.repository.BuildingRepository;
import com.example.async_test.domain.repository.ElevatorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class InternalService {

    private final BuildingRepository buildingRepository;
    private final ElevatorRepository elevatorRepository;

    // 모든건물의 모든 작동중인 엘리베이터를 움직인다.
    public void move(){
        List<Elevator> elevators = elevatorRepository.findByStatus(Status.OPERATION);
        elevators.forEach(elevator -> {
            elevator.closeDoor();
            if(elevator.nowDestination() - elevator.getFloor() > 0){ // 위로 가야하는 경우
                elevator.changeState(State.UP);
                elevator.goUp();
            } else if(elevator.nowDestination() - elevator.getFloor() < 0){
                elevator.changeState(State.DOWN);
                elevator.goDown();
            }
        });
    }

    public void arrive(){
        List<Elevator> elevators = elevatorRepository.findByStatus(Status.OPERATION);
        elevators.forEach(elevator -> {
            if(elevator.arrive()){
                elevator.openDoor();
                elevator.removeDest(elevator.getFloor());
            }
        });
    }
}
