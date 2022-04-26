package com.example.async_test.rest.controller;

import com.example.async_test.domain.Building;
import com.example.async_test.domain.Elevator;
import com.example.async_test.rest.service.ProduceService;
import com.example.async_test.util.dto.CreateElevatorReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 빌딩과 엘리베이터를 생성하는 역할
 */

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/produce")
public class ProduceController {

    private final ProduceService produceService;

    @PostMapping("/building")
    public void createBuilding(String name){
        produceService.createBuilding(name);
    }

    @PostMapping("/elevator")
    public void createElevator(CreateElevatorReq elevatorReq){
        produceService.createElevator(elevatorReq);
    }
}
