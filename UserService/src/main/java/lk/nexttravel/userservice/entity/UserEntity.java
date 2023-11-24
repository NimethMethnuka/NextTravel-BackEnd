package lk.nexttravel.userservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String id;
    String name;
    double category;
    String location;
    String locationCoordinates;
    String email;
    String contact_number_01;
    String contact_number_02;
    boolean isPetAllowed;
    double full_board_double_fee;
    double half_board_double_fee;
    double full_board_triple_fee;
    double half_board_triple_fee;
    double hotel_fee;
    String cancellationCriteria;
    String remarks;

}
