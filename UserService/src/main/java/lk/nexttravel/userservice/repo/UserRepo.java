package lk.nexttravel.userservice.repo;

import lk.nexttravel.userservice.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserEntity, String> {

}
