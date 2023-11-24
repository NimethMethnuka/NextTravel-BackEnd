package lk.nexttravel.userservice.service.impl;

import lk.nexttravel.userservice.dto.UserDTO;
import lk.nexttravel.userservice.entity.UserEntity;
import lk.nexttravel.userservice.repo.UserRepo;
import lk.nexttravel.userservice.service.custom.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        UserEntity userEntity = modelMapper.map(userDTO, UserEntity.class);
        return modelMapper.map(userRepo.save(userEntity), UserDTO.class);

    }

    @Override
    public UserDTO getUserById(String id) {
        Optional<UserEntity> user = userRepo.findById(id);
        UserDTO userDTO = null;
        if (user.isPresent()) {
            userDTO = modelMapper.map(user.get(), UserDTO.class);
        }
        return userDTO;
    }

    @Override
    public boolean deleteUser(String id) {
        if (getUserById(id) != null){
            userRepo.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        UserEntity userEntity = modelMapper.map(userDTO, UserEntity.class);
        return modelMapper.map(userRepo.save(userEntity), UserDTO.class);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepo.findAll().stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }
}
