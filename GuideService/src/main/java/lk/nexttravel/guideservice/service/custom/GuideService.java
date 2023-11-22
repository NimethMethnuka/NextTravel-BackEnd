package lk.nexttravel.guideservice.service.custom;

import lk.nexttravel.guideservice.dto.GuideDTO;
import lk.nexttravel.guideservice.entity.Guide;
import lk.nexttravel.guideservice.response.ResponseUtil;

import java.util.List;
import java.util.Optional;

// No need of a SuperService because there is only one service class.
// It is needed to represent all the service interfaces when there are many.
// This interface is there to loosely couple the GuideServiceImpl.
public interface GuideService {
    public GuideDTO saveGuide(GuideDTO guideDTO);

    public GuideDTO getGuideById(String id);

    public boolean deleteGuide(String id);

    public GuideDTO updateGuide(GuideDTO guideDTO);

    public List<GuideDTO> getAllGuides();
}
