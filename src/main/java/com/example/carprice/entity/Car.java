package com.example.carprice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cars")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Where(clause = "is_deleted is null")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;
    private String number;
    @Column(name = "is_buy")
    private boolean isBuy;
    @Column (name = "is_deleted")
    private Date isDeleted;
    private Integer price;
}
