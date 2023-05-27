package com.ua.hibernate.service;
import com.ua.hibernate.domain.City;
import com.ua.hibernate.domain.Country;
import com.ua.hibernate.dto.CityDto;
import com.ua.hibernate.repository.CityRepository;
import com.ua.hibernate.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CityService {
    private final CityRepository cityRepository;
    private final CountryRepository countryRepository;

    public void save(City city) {
        cityRepository.save(city);
    }

    public List<CityDto> findAll() {
        return cityRepository.findAll().stream()
                .map(CityService::buildCityDto).collect(Collectors.toList());
    }

    private static CityDto buildCityDto(City city) {
        return CityDto.builder()
                .id(city.getId())
                .name(city.getName())
                .state(city.getState())
                .countryName(city.getCountry().getName())
                .build();
    }

    public void addCountry(int cityId,int countryId){
        Country country = countryRepository.findById(countryId).get();
        City city = cityRepository.findById(cityId).get();
        city.setCountry(country);
        cityRepository.save(city);
    }
}
