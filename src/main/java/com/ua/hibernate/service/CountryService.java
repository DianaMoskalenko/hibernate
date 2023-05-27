package com.ua.hibernate.service;
import com.ua.hibernate.domain.Country;
import com.ua.hibernate.dto.CountryDto;
import com.ua.hibernate.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CountryService {
    private final CountryRepository countryRepository;

    public void save(Country country) {
        countryRepository.save(country);
    }

    public List<CountryDto> findAll() {
        return countryRepository.findAll()
                .stream().map(CountryService::buildCountryDto).collect(Collectors.toList());
    }

    private static CountryDto buildCountryDto(Country country) {
        return CountryDto.builder().
                id(country.getId())
                .nane(country.getName())
                .capital(country.getCapital())
                .population(country.getPopulation())
                .cityName(country.getCityList()
                        .stream().map(x->x.getName()).collect(Collectors.toList()))
                .build();
    }
}
