package lk.nexttravel.guideservice.repo;

import lk.nexttravel.guideservice.entity.Guide;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuideRepo extends JpaRepository<Guide, String> {
}
