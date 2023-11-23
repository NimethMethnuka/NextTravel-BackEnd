package lk.nexttravel.hotelservice.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class HotelDTO {
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
