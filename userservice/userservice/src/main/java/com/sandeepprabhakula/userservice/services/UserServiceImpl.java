package com.sandeepprabhakula.userservice.services;

import com.sandeepprabhakula.userservice.entities.Hotel;
import com.sandeepprabhakula.userservice.entities.Rating;
import com.sandeepprabhakula.userservice.entities.Users;
import com.sandeepprabhakula.userservice.external.services.HotelService;
import com.sandeepprabhakula.userservice.external.services.RatingService;
import com.sandeepprabhakula.userservice.repositories.UserRepository;
import com.sandeepprabhakula.userservice.services.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final HotelService hotelService;

    private final RatingService ratingService;

    @Override
    public Users save(Users user) {
        String uid = UUID.randomUUID().toString();
        user.setUid(uid);
        return userRepository.save(user);
    }

    @Override
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Users getUser(String uid) {
        Users user = userRepository.findById(uid)
                .orElseThrow(() -> new ResourceNotFoundException("User Not found with id" + uid));

        List<Rating> ratings = ratingService.getRatingsByUID(uid);
        List<Rating> ratingList = ratings.stream().map(rating -> {
            Hotel hotel = hotelService.getHotel(rating.getHotelId());
            rating.setHotel(hotel);
            return rating;
        }).collect(Collectors.toList());
        user.setRatings(ratingList);
        return user;
    }

}
