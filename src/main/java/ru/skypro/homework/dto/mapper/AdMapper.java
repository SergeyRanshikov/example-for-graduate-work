package ru.skypro.homework.dto.mapper;

import ru.skypro.homework.dto.AdDto;
import ru.skypro.homework.dto.CreateOrUpdateAdDto;
import ru.skypro.homework.model.Ad;

public class AdMapper {

    public static AdDto adToAdDto(Ad ad) {
        AdDto dto = new AdDto();
        dto.setPk(ad.getId());
        dto.setAuthor(ad.getAuthor().getId());
        dto.setImage(ad.getImage());
        dto.setPrice(ad.getPrice());
        dto.setTitle(ad.getTitle());
        return dto;
    }

    public static Ad createOrUpdateAdFromDto(CreateOrUpdateAdDto dto) {
        Ad ad = new Ad();
        ad.setTitle(dto.getTitle());
        ad.setPrice(dto.getPrice());
        ad.setDescription(dto.getDescription());
        return ad;
    }
}
