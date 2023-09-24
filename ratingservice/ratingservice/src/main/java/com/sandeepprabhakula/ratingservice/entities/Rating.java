package com.sandeepprabhakula.ratingservice.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Getter
@AllArgsConstructor
@Setter
@NoArgsConstructor
@Document("ratings")
public class Rating {
    @Id
    private String ratingId;
    private String uid;
    private String hotelId;
    private int rating;
    private String feedback;
}
