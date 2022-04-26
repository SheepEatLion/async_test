package com.example.async_test.rest.controller;

import com.example.async_test.domain.enums.LiftType;
import com.example.async_test.rest.service.ExternalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/external")
@RequiredArgsConstructor
@RestController
public class ExternalController {

    private final ExternalService externalService;

    @PostMapping("/go-up")
    public void goUp(int currLoc, String buildingName, LiftType liftType){
        log.info("[goUP] " + buildingName + "건물의 " + currLoc + "층에서 업 버튼을 눌렀습니다.");
        externalService.goUp(currLoc, buildingName, liftType);
        log.info("[goUP] " + buildingName + "건물의 " + currLoc + "층에 도착하였습니다.");
    }

    public void goDown(){

    }

    public void systemCheck(){

    }

    public void cancel(){

    }
}

