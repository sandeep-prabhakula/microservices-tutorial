package com.sandeepprabhakula.hotelservice.service;

import com.sandeepprabhakula.hotelservice.entities.Hotel;

import java.util.List;

public interface HotelService {
    Hotel save(Hotel hotel);

    List<Hotel> getAllHotels();

    Hotel getHotel(String hotelId);
}
