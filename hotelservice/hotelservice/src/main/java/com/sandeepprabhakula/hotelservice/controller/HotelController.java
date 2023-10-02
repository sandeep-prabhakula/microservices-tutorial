package com.sandeepprabhakula.hotelservice.controller;

import com.sandeepprabhakula.hotelservice.entities.Hotel;
import com.sandeepprabhakula.hotelservice.repository.HotelRepository;
import com.sandeepprabhakula.hotelservice.service.HotelServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/hotels")
public class HotelController {
    private final HotelServiceImpl hotelService;
    @PostMapping("/add-hotel")
    @PreAuthorize("hasAuthority('Admin')")
    public ResponseEntity<Hotel> addHotel(@RequestBody Hotel hotel){
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.save(hotel));
    }

    @GetMapping("/all-hotel")
    @PreAuthorize("hasAuthority('SCOPE_internal') || hasAuthority('Admin')")
    public ResponseEntity<List<Hotel>> getAllHotels(){
        return ResponseEntity.ok(hotelService.getAllHotels());
    }

    @GetMapping("/{hotelId}")
    @PreAuthorize("hasAuthority('SCOPE_internal')")
    public ResponseEntity<Hotel> getHotelById(@PathVariable("hotelId") String hotelId){
        return ResponseEntity.status(HttpStatus.OK).body(hotelService.getHotel(hotelId));
    }

}
