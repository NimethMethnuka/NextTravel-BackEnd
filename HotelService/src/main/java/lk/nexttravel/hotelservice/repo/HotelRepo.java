package lk.nexttravel.hotelservice.repo;

import lk.nexttravel.hotelservice.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepo extends JpaRepository<Hotel, String> {

}
