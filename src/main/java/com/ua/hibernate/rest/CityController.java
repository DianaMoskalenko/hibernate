package com.ua.hibernate.rest;


import com.ua.hibernate.domain.City;
import com.ua.hibernate.dto.CityDto;
import com.ua.hibernate.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CityController {
    private final CityService cityService;
    @PostMapping("/city")
    public ResponseEntity<Void> save (@RequestBody City city){
        cityService.save(city);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @GetMapping("/city")
    public ResponseEntity<List<CityDto>> findAll(){
        return ResponseEntity.ok(cityService.findAll());
    }
    @PostMapping("/city/{idCity}/country/{idCountry}")
    public ResponseEntity<Void> addCountry(@PathVariable int idCity, @PathVariable int idCountry){
        cityService.addCountry(idCity,idCountry);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
