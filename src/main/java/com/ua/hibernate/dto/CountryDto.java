package com.ua.hibernate.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Builder
@Getter
@Setter
public class CountryDto {
    private int id;
    private String nane;
    private String capital;
    private float population;
    private List<String> cityName;

}