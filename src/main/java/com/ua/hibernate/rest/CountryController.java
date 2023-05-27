package com.ua.hibernate.rest;

import com.ua.hibernate.domain.Country;
import com.ua.hibernate.service.CountryService;
import com.ua.hibernate.dto.CountryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CountryController {
    private final CountryService countryService;

    @PostMapping("/country")
    public ResponseEntity<Void> save(@RequestBody Country country) {
        countryService.save(country);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/country")
    public ResponseEntity<List<CountryDto>> findAll() {
        return ResponseEntity.ok(countryService.findAll());
    }
}
