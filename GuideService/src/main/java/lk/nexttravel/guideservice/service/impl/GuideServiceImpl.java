package lk.nexttravel.guideservice.service.impl;

import lk.nexttravel.guideservice.dto.GuideDTO;
import lk.nexttravel.guideservice.entity.Guide;
import lk.nexttravel.guideservice.repo.GuideRepo;
import lk.nexttravel.guideservice.response.ResponseUtil;
import lk.nexttravel.guideservice.service.custom.GuideService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class GuideServiceImpl implements GuideService {

    @Autowired
    GuideRepo guideRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public GuideDTO saveGuide(GuideDTO guideDTO) {
        Guide guide = guideRepo.save(modelMapper.map(guideDTO, Guide.class));
        return modelMapper.map(guide, GuideDTO.class);
    }

    @Override
    public GuideDTO getGuideById(String id) {
        Optional<Guide> guide = guideRepo.findById(id);
        GuideDTO guideDTO = null;
        if (guide.isPresent()){
            guideDTO = modelMapper.map(guide.get(), GuideDTO.class);
        }
        return guideDTO;
    }

    @Override
    public boolean deleteGuide(String id) { // returns false if the guide does not exist
        if (getGuideById(id) != null){
            guideRepo.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public GuideDTO updateGuide(GuideDTO guideDTO) {
        return modelMapper.map(guideRepo.save(modelMapper.map(guideDTO, Guide.class)), GuideDTO.class);
    }

    @Override
    public List<GuideDTO> getAllGuides() {
        return guideRepo.findAll().stream()
                .map(guide -> modelMapper.map(guide, GuideDTO.class))
                .collect(Collectors.toList());
    }

//    @Override
//    public ResponseUtil saveGuide(GuideDTO guideDTO){
//        if (searchGuide(guideDTO.getId()).getData() == null){
//            guideRepo.save(modelMapper.map(guideDTO, Guide.class));
//            return new ResponseUtil(null, "200", "Guide saved successfully!");
//        }
//        return new ResponseUtil(null, "409", "Guide already exists!");
//    }
//
//    @Override
//    public Optional<Guide> searchGuide(String id){
//        return guideRepo.findById(id);
//    }
//
//    @Override
//    public ResponseUtil deleteGuide(String id){ //
//        if (searchGuide(id).getData() != null){
//            guideRepo.deleteById(id);
//            return new ResponseUtil(null, "200", "Guide deleted successfully");
//        }
//        return new ResponseUtil(null, "404", "Guide not found!");
//    }
//
//    @Override
//    public ResponseUtil updateGuide(GuideDTO guideDTO){
//        if (searchGuide(guideDTO.getId()) != null){
//            guideRepo.save(modelMapper.map(guideDTO, Guide.class));
//            return new ResponseUtil(null, "200", "Guide updated successfully!");
//        }
//        return new ResponseUtil(null, "404", "Unable to update, Guide not found!");
//    }
//
//    @Override
//    public ResponseUtil getAllGuides(){
//        List<GuideDTO> guideDTOList = null;
//        guideRepo.findAll().forEach(guide -> {
//            guideDTOList.add(modelMapper.map(guide, GuideDTO.class));
//        });
//
//        if (guideDTOList != null){
//            return new ResponseUtil(guideDTOList, "200", "Guides retrieved successfully!");
//        }
//        return new ResponseUtil(guideDTOList, "404", "Guides not found!");
//    }
}
