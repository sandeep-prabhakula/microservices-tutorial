package com.sandeepprabhakula.userservice.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rating {
    private String ratingId;
    private String uid;
    private String hotelId;
    private int rating;
    private String feedback;
    private Hotel hotel;
}
