package com.sandeepprabhakula.userservice.controller;

import com.sandeepprabhakula.userservice.entities.Users;
import com.sandeepprabhakula.userservice.services.UserServiceImpl;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserServiceImpl userService;


    @PostMapping("/add-user")
    public Users addUser(@RequestBody Users user) {
        return userService.save(user);
    }

    int retryCount = 1;
    @GetMapping("/{uid}")
//    @CircuitBreaker(name = "RATING_HOTEL_BREAKER", fallbackMethod = "ratingHotelFallback")
//    @Retry(name = "RATING_HOTEL_SERVICE", fallbackMethod = "ratingHotelFallback")
    @RateLimiter(name="RATING_HOTEL_LIMITER", fallbackMethod = "ratingHotelFallback")  // install jmeter for testing @RateLimiter feature
    public Users getUser(@PathVariable("uid") String uid) {
        System.out.println("retry count : "+retryCount);
        retryCount++;
        return userService.getUser(uid);
    }

    @GetMapping("/all-users")
    public List<Users> getAllUsers() {
        return userService.getAllUsers();
    }

    //fallback method of circuit breaker
    public Users ratingHotelFallback(String uid, Exception ex) {
        System.out.println("Fallback executed service down : " + ex.getMessage());
        Users user = Users
                .builder()
                .email("dummy@gmail.com")
                .name("name")
                .about("this user is created ")
                .build();
        return user;
    }

}
