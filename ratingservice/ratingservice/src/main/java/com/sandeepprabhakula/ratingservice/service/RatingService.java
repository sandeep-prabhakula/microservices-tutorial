package com.sandeepprabhakula.ratingservice.service;

import com.sandeepprabhakula.ratingservice.entities.Rating;

import java.util.List;

public interface RatingService {

    Rating save(Rating rating);

    List<Rating> getAllRating();

    List<Rating> getRatingByUserId(String uid);

    List<Rating> getRatingByHotelId(String hotelId);

}
