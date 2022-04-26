package com.example.async_test.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "building", cascade = CascadeType.ALL)
    private List<Elevator> elevators;

    /**
     * 빌딩 기능
     */

    public static Building building(String name){
        Building building = new Building();
        building.name = name;
        building.elevators = null;
        return building;
    }

    public void addElevator(Elevator elevator){
        this.elevators.add(elevator);
    }

    public void removeElevator(Elevator elevator){
        this.elevators.remove(elevator);
    }
}
