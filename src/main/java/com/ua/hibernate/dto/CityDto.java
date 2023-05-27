package com.ua.hibernate.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class CityDto {
    private int id;
    private String name;
    private String state;
    private String countryName;
}
