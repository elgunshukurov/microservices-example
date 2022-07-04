package az.elgunsh.microserviesrelationsliqubase.controller;

import az.elgunsh.microserviesrelationsliqubase.domain.Phone;
import az.elgunsh.microserviesrelationsliqubase.dto.PhoneResponseDto;
import az.elgunsh.microserviesrelationsliqubase.service.PhoneService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/index")
public class PhoneController {
    private final PhoneService service;

    @GetMapping("/{id}/phones")
    public List<PhoneResponseDto> getPhones(@RequestParam long id) {
        return service.getPhonesById(id);
    }

    @PostMapping("/{id}/phones")
    public List<PhoneResponseDto> createPhones(@RequestParam long id, @RequestBody Phone phone){
        return service.createPhones(id, phone);
    }

    @PutMapping("/{id}/phones/{phoneId}")
    public List<PhoneResponseDto> updatePhones(
            @RequestParam long id,
            @RequestParam long phoneId,
            @RequestBody Phone phone){



        return service.updatePhones(id, phoneId, phone);
    }
}
