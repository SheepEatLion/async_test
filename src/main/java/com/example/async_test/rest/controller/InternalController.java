package com.example.async_test.rest.controller;

import com.example.async_test.rest.service.InternalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class InternalController {

    private final InternalService internalService;

    public void floor(){

    }

    public void openDoor(){

    }

    public void closeDoor(){

    }

    public void emergency(){

    }

    public void cancel(){

    }

    public void moveAndArrive(){
        internalService.move();
        internalService.arrive();
    }
}
