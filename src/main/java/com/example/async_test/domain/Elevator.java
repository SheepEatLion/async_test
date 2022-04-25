package com.example.async_test.domain;

import com.example.async_test.domain.enums.Condition;
import com.example.async_test.domain.enums.LiftType;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Elevator {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Condition condition;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private LiftType type;

    @Column(nullable = false)
    private Integer weight;

    @Column(nullable = false)
    private Integer floor;

    @Column(nullable = false)
    private Integer minRange;

    @Column(nullable = false)
    private Integer maxRange;

    @Column(nullable = false)
    private Integer[] dest;

}
