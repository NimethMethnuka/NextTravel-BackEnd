package lk.nexttravel.userservice.controller;

import lk.nexttravel.userservice.dto.UserDTO;
import lk.nexttravel.userservice.service.custom.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(path = "/save", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO){
        UserDTO dto = userService.saveUser(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @DeleteMapping(path = "/delete", params = {"id"}, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteUser(@RequestParam String id){
        if (userService.deleteUser(id)){
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping(path = "/update", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO){
        UserDTO dto = userService.updateUser(userDTO);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @GetMapping(path = "/search", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> searchUser(@RequestParam String id){
        UserDTO userDTO = userService.getUserById(id);
        return ResponseEntity.status(HttpStatus.OK).body(userDTO);
    }

    @GetMapping(path = "/getAll")
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        List<UserDTO> userDTOList = userService.getAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body(userDTOList);
    }
}
