package com.sandeepprabhakula.userservice.external.services;

import com.sandeepprabhakula.userservice.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "RATING-SERVICE")
public interface RatingService {
    @GetMapping("ratings/ratings-by-uid/{uid}")
    List<Rating> getRatingsByUID(@PathVariable("uid") String uid);

    @GetMapping("ratings/ratings-by-hotelId/{hotelId}")
    List<Rating> getRatingsByHotelId(@PathVariable("hotelId") String hotelId) ;
}
