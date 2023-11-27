package com.codephety.app.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

}
