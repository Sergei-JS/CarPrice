package com.example.carprice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;
import javax.persistence.*;
import java.util.Date;
@Entity
@Table (name="users")
@AllArgsConstructor
@NoArgsConstructor
@Data

@Where(clause = "is_deleted is null") //показывает только тех пользователей, которые не удалены.

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    @Column(name = "money_amount")
    private Integer moneyAmount;
    @Column(name = "is_deleted")
    private Date isDeleted;
    @Column(name = "car_num")
    private String crNumber;
}
