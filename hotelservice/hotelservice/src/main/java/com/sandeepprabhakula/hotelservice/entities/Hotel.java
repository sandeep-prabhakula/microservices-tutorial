package com.sandeepprabhakula.hotelservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {
    @Id
    private String hotelId;
    private String hotelName;
    private String location;
    private String about;
}
