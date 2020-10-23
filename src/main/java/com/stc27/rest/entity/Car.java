package com.stc27.rest.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



    @Entity
    @Data
    @NoArgsConstructor
    @Table(name = "cars")
    public class Car {

        @Id
        private Integer id;

        @Column(name = "model")
        private String model;

        @Column(name = "color")
        private String color;

        @Column(name = "horse_power")
        private Long horsePower;
    }


