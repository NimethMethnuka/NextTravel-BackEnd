package lk.nexttravel.guideservice.controller;

import com.sun.tools.jconsole.JConsoleContext;
import lk.nexttravel.guideservice.dto.GuideDTO;
import lk.nexttravel.guideservice.response.ResponseUtil;
import lk.nexttravel.guideservice.service.custom.GuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/guide")
@CrossOrigin
public class GuideController {

    @Autowired
    GuideService guideService;

    @PostMapping(path = "/save", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GuideDTO> saveGuide(@RequestBody GuideDTO guideDTO){
        GuideDTO dto = guideService.saveGuide(guideDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @DeleteMapping(path = "/delete", params = {"id"}, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteGuide(@RequestParam String id){
        if (guideService.deleteGuide(id)){
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping(path = "/update", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GuideDTO> updateGuide(@RequestBody GuideDTO guideDTO){
        GuideDTO dto = guideService.updateGuide(guideDTO);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @GetMapping(path = "/search", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GuideDTO> searchGuide(@RequestParam String id){
        GuideDTO guideDTO = guideService.getGuideById(id);
        return ResponseEntity.status(HttpStatus.OK).body(guideDTO);
    }

    @GetMapping(path = "/getAll")
    public ResponseEntity<List<GuideDTO>> getAllGuides(){
        List<GuideDTO> guideDTOList = guideService.getAllGuides();
        return ResponseEntity.status(HttpStatus.OK).body(guideDTOList);
    }
}
