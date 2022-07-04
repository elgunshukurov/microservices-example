package az.elgunsh.microservicesspringtransactions.controller;


import az.elgunsh.microservicesspringtransactions.service.UserService;
import az.elgunsh.microservicesspringtransactions.dto.UserRequestDto;
import az.elgunsh.microservicesspringtransactions.dto.UserResponseDto;
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

    @GetMapping("/criteria")
    public List<UserResponseDto> getInfoByCriteria(
            @RequestParam Map<String, String> map) {
        return service.getUserByCriteria(map);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDto saveInfo(@RequestBody UserRequestDto userDto) throws  Throwable{
        return service.saveUser(userDto);
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
