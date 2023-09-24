package com.sandeepprabhakula.ratingservice.controller;

import com.sandeepprabhakula.ratingservice.entities.Rating;
import com.sandeepprabhakula.ratingservice.service.RatingServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ratings")
public class RatingController {
    private final RatingServiceImpl ratingService;

    @PostMapping("/add-rating")
    public ResponseEntity<Rating> create(@RequestBody Rating rating) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.save(rating));
    }

    @GetMapping("/all-ratings")
    public ResponseEntity<List<Rating>> getAllRating() {
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.getAllRating());
    }

    @GetMapping("/ratings-by-uid/{uid}")
    public ResponseEntity<List<Rating>> getRatingsByUID(@PathVariable("uid") String uid) {
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.getRatingByUserId(uid));
    }

    @GetMapping("/ratings-by-hotelId/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable("hotelId") String hotelId) {
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.getRatingByHotelId(hotelId));
    }
}
