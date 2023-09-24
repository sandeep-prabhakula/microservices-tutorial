package com.sandeepprabhakula.ratingservice.repositories;

import com.sandeepprabhakula.ratingservice.entities.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends MongoRepository<Rating,String> {
    List<Rating> findAllByUid(String uid);

    List<Rating> findAllByHotelId(String hotelId);
}
