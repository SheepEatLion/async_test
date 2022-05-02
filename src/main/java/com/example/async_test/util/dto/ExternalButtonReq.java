package com.example.async_test.util.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ExternalButtonReq {
    private Integer currLoc;        // 현재 위치 (층)
    private String buildingName;    // 건물 이름
}
