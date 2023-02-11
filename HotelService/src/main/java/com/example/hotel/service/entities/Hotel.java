package com.example.hotel.service.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="hotels")
public class Hotel {

    @Id
    @Column(name="hotel_id")
    private String hotelId;

    @Column(name="name")
    private String name;

    @Column(name="location")
    private String location;

    @Column(name="about")
    private String about;
}
