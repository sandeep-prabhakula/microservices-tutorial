package com.sandeepprabhakula.ratingservice.service;

import com.sandeepprabhakula.ratingservice.entities.Rating;
import com.sandeepprabhakula.ratingservice.repositories.RatingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RatingServiceImpl implements RatingService {
    private final RatingRepository ratingRepository;
    @Override
    public Rating save(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getAllRating() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> getRatingByUserId(String uid) {
        return ratingRepository.findAllByUid(uid);
    }

    @Override
    public List<Rating> getRatingByHotelId(String hotelId) {
        return ratingRepository.findAllByHotelId(hotelId);
    }
}
