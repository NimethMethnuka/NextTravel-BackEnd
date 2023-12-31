package lk.nexttravel.hotelservice.controller;

import lk.nexttravel.hotelservice.dto.HotelDTO;
import lk.nexttravel.hotelservice.service.custom.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hotel")
@CrossOrigin
public class HotelController {

    @Autowired
    HotelService hotelService;

    @PostMapping(path = "/save", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HotelDTO> saveHotel(@RequestBody HotelDTO hotelDTO){
        HotelDTO dto = hotelService.saveHotel(hotelDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @DeleteMapping(path = "/delete", params = {"id"}, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteHotel(@RequestParam String id){
        if (hotelService.deleteHotel(id)){
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping(path = "/update", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HotelDTO> updateHotel(@RequestBody HotelDTO hotelDTO){
        HotelDTO dto = hotelService.updateHotel(hotelDTO);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @GetMapping(path = "/search", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HotelDTO> searchHotel(@RequestParam String id){
        HotelDTO hotelDTO = hotelService.getHotelById(id);
        return ResponseEntity.status(HttpStatus.OK).body(hotelDTO);
    }

    @GetMapping(path = "/getAll")
    public ResponseEntity<List<HotelDTO>> getAllHotels(){
        List<HotelDTO> hotelDTOList = hotelService.getAllHotels();
        return ResponseEntity.status(HttpStatus.OK).body(hotelDTOList);
    }
}
