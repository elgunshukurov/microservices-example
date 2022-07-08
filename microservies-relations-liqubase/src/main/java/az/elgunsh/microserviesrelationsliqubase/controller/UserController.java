package az.elgunsh.microserviesrelationsliqubase.controller;


import az.elgunsh.microserviesrelationsliqubase.dto.UserRequestDto;
import az.elgunsh.microserviesrelationsliqubase.dto.UserResponseDto;
import az.elgunsh.microserviesrelationsliqubase.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/index")
public class UserController {
    private final UserService service;

    @GetMapping("/all")
    public List<UserResponseDto> getAllUsers() {
        return service.getUserList();
    }

    @GetMapping("/criteria")
    public List<UserResponseDto> getInfoByCriteria(
            @RequestParam Map<String, String> map) {
        List<UserResponseDto> userByCriteria = service.getUserByCriteria(map);
        return userByCriteria;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDto saveInfo(@RequestBody UserRequestDto scientistDto) {
        log.info("{}",scientistDto);
        return service.saveUser(scientistDto);
    }

    @PutMapping("/{id}")
    public UserResponseDto updateInfo(@PathVariable long id,
                                      @RequestBody UserRequestDto dto) {
        return service.updateUser(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public long deleteInfo(@PathVariable long id) {
        return service.deleteUser(id);
    }
}
