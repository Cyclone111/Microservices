package com.example.user.service.entities;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rating {

    private String ratingId;
    private String userId;
    private String remarks;
    private int rating;
    private String hotelId;
    private Hotel hotel;
}
