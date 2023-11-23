package lk.nexttravel.hotelservice.service.custom;

import lk.nexttravel.hotelservice.dto.HotelDTO;

import java.util.List;

public interface HotelService {
    public HotelDTO saveHotel(HotelDTO hotelDTO);

    public HotelDTO getHotelById(String id);

    public boolean deleteHotel(String id);

    public HotelDTO updateHotel(HotelDTO hotelDTO);

    public List<HotelDTO> getAllHotels();
}
