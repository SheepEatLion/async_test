package com.example.async_test.rest.service;

import com.example.async_test.domain.Building;
import com.example.async_test.domain.Elevator;
import com.example.async_test.domain.enums.LiftType;
import com.example.async_test.domain.enums.State;
import com.example.async_test.domain.enums.Status;
import com.example.async_test.domain.repository.BuildingRepository;
import com.example.async_test.domain.repository.ElevatorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class ExternalService {

    private final BuildingRepository buildingRepository;
    private final ElevatorRepository elevatorRepository;

    public void goUp(int currLoc, String buildingName, LiftType liftType){

        Building building = buildingRepository.findByName(buildingName);    // querydsl 적용 후 리팩터링 필요
        List<Elevator> elevators = elevatorRepository.findByTypeAndStatusAndBuilding(liftType, Status.OPERATION, building);
        // 핵심 로직 (가장 가까운 엘리베이터 찾기), 모두 같은 층인 경우 / 같은 층도 있지만 다른층도 있는 경우
        // 우선순위 (층이 더 가까운가, 문이 닫혀있는가, 올라가는 중인가 내려가는 중인가) --> 요청만 넣어주고 다른 로직에서 해결하는게 맞는듯.
        for(Elevator elevator : elevators){
            elevator.addDest(currLoc);
        }

    }
}
