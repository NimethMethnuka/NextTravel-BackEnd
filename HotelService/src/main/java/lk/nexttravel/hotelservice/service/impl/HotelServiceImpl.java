package lk.nexttravel.hotelservice.service.impl;

import lk.nexttravel.hotelservice.dto.HotelDTO;
import lk.nexttravel.hotelservice.entity.Hotel;
import lk.nexttravel.hotelservice.repo.HotelRepo;
import lk.nexttravel.hotelservice.service.custom.HotelService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class HotelServiceImpl implements HotelService {

    @Autowired
    HotelRepo hotelRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public HotelDTO saveHotel(HotelDTO hotelDTO) {
        Hotel hotelEntity = modelMapper.map(hotelDTO, Hotel.class);
        return modelMapper.map(hotelRepo.save(hotelEntity), HotelDTO.class);

    }

    @Override
    public HotelDTO getHotelById(String id) {
        Optional<Hotel> hotel = hotelRepo.findById(id);
        HotelDTO hotelDTO = null;
        if (hotel.isPresent()) {
            hotelDTO = modelMapper.map(hotel.get(), HotelDTO.class);
        }
        return hotelDTO;
    }

    @Override
    public boolean deleteHotel(String id) {
        if (getHotelById(id) != null){
            hotelRepo.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public HotelDTO updateHotel(HotelDTO hotelDTO) {
        Hotel hotelEntity = modelMapper.map(hotelDTO, Hotel.class);
        return modelMapper.map(hotelRepo.save(hotelEntity), HotelDTO.class);
    }

    @Override
    public List<HotelDTO> getAllHotels() {
        return hotelRepo.findAll().stream()
                .map(hotel -> modelMapper.map(hotel, HotelDTO.class))
                .collect(Collectors.toList());
    }
}
