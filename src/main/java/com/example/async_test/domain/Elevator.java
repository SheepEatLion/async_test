package com.example.async_test.domain;

import com.example.async_test.domain.enums.Door;
import com.example.async_test.domain.enums.State;
import com.example.async_test.domain.enums.Status;
import com.example.async_test.domain.enums.LiftType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.List;

@Slf4j
@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Elevator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private State state;

    @Enumerated(value = EnumType.STRING)
    private Door door;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Status status;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private LiftType type;

    @Column(nullable = false)
    private Integer floor;

    @Column(nullable = false)
    private Integer minRange;

    @Column(nullable = false)
    private Integer maxRange;

    @Column(nullable = false)
    @ElementCollection(targetClass = Integer.class)
    private List<Integer> destinations;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Building building;


    /**
     *  엘리베이터 기능
     */
    public static Elevator elevator(LiftType type, Integer minRange, Integer maxRange, Building building){
        Elevator elevator = new Elevator();
        elevator.state = State.STAND;
        elevator.door = Door.CLOSE;
        elevator.status = Status.STOP;
        elevator.type = type;
        elevator.floor = 1;
        elevator.minRange = minRange;
        elevator.maxRange = maxRange;
        elevator.destinations = null;
        elevator.building = building;
        log.info("새로운 엘리베이터를 만들었습니다.");
        return elevator;
    }

    public void openDoor(){
        this.door = Door.OPEN;
        log.info("문이 열립니다.");
    }

    public void closeDoor(){
        this.door = Door.CLOSE;
        log.info("문이 닫힙니다.");
    }

    public void changeState(State state){
        this.state = state;
        log.info(state + "상태로 변경되었습니다.");
    }

    public void addDest(Integer dest){
        this.destinations.add(dest);
        log.info(dest + "층이 입력되었습니다.");
    }

    public void removeDest(Integer dest){
        this.destinations.remove(dest);
    }

    public void goUp(){
        this.floor += 1;
    }
    public void goDown(){
        this.floor -= 1;
    }

    public void changeStatus(Status status){
        this.status = status;
    }

    public boolean arrive(){
        if(this.destinations.contains(this.floor)){
            log.info(this.floor + "층에 도착하였습니다.");
            return true;
        }
        return false;
    }

    public Integer nowDestination(){
        if(!this.getDestinations().isEmpty()){
            return this.getDestinations().get(0);
        }
        return null;
    }

}
