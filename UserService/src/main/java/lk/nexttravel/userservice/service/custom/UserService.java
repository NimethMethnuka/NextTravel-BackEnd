package lk.nexttravel.userservice.service.custom;

import lk.nexttravel.userservice.dto.UserDTO;

import java.util.List;

public interface UserService {
    public UserDTO saveUser(UserDTO userDTO);

    public UserDTO getUserById(String id);

    public boolean deleteUser(String id);

    public UserDTO updateUser(UserDTO userDTO);

    public List<UserDTO> getAllUsers();
}
