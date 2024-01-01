package ru.skypro.homework.dto.mapper;

import ru.skypro.homework.dto.AdDto;
import ru.skypro.homework.dto.CreateOrUpdateAdDto;
import ru.skypro.homework.dto.ExtendedAdDto;
import ru.skypro.homework.model.Ad;
import ru.skypro.homework.repository.UserRepository;


public class AdMapper {

    private static UserRepository userRepository;

    public AdMapper(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static AdDto adToAdDto(Ad ad) {
        AdDto dto = new AdDto();
        dto.setPk(ad.getId());
        dto.setAuthor(ad.getAuthor().getId());
        dto.setImage(ad.getImageUrl());
        dto.setPrice(ad.getPrice());
        dto.setTitle(ad.getTitle());
        return dto;
    }

    public static Ad adDtoToAd(AdDto dto) {
        Ad ad = new Ad();
        ad.setId(dto.getPk());
        ad.setId(dto.getPk());
        ad.setAuthor(userRepository.findById(dto.getAuthor()).orElse(null));
        ad.setImageUrl(dto.getImage());
        ad.setPrice(dto.getPrice());
        ad.setTitle(dto.getTitle());
        return ad;
    }


    public static Ad createOrUpdateAdFromDto(CreateOrUpdateAdDto dto) {
        Ad ad = new Ad();
        ad.setTitle(dto.getTitle());
        ad.setPrice(dto.getPrice());
        ad.setDescription(dto.getDescription());
        return ad;
    }

    public static CreateOrUpdateAdDto adToCreateOrUpdateAdDto(Ad ad) {
        CreateOrUpdateAdDto dto = new CreateOrUpdateAdDto();
        dto.setTitle(ad.getTitle());
        dto.setPrice(ad.getPrice());
        dto.setDescription(ad.getDescription());
        return dto;
    }

    public static ExtendedAdDto adToExtendedAdDto(Ad ad) {
        ExtendedAdDto dto = new ExtendedAdDto();
        dto.setPk(ad.getId());
        dto.setAuthorFirstName(ad.getAuthor().getFirstName());
        dto.setAuthorLastName(ad.getAuthor().getLastName());
        dto.setDescription(ad.getDescription());
        dto.setEmail(ad.getAuthor().getEmail());
        dto.setImage(ad.getImageUrl());
        dto.setPhone(ad.getAuthor().getPhone());
        dto.setPrice(ad.getPrice());
        dto.setTitle(ad.getTitle());
        return dto;
    }

    public static Ad extendedAdDtoToAd(ExtendedAdDto dto, Ad ad) {
        ad.setTitle(dto.getTitle());
        ad.setPrice(dto.getPrice());
        ad.setDescription(dto.getDescription());
        ad.setImageUrl(dto.getImage());
        return ad;
    }
}