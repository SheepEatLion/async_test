package com.example.async_test.util.dto;

import com.example.async_test.domain.enums.LiftType;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateElevatorReq {
    private LiftType liftType;
    private Integer minRange;
    private Integer maxRange;
    private String buildingName;
}
