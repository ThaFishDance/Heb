package com.tcb.heb.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, name = "street")
    private String street;
    @Column(nullable = false, name = "city")
    private String city;
    @Column(nullable = false, name = "state")
    private String state;
    @Column(nullable = false, name = "zip")
    private String zip;
}
