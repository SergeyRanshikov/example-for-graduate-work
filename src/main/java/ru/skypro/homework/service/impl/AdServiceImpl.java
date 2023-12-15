package ru.skypro.homework.service.impl;

import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.AdDto;
import ru.skypro.homework.dto.AdsDto;
import ru.skypro.homework.dto.CreateOrUpdateAdDto;
import ru.skypro.homework.dto.ExtendedAdDto;
import ru.skypro.homework.service.AdService;

@Service
public class AdServiceImpl implements AdService {
    @Override
    public AdsDto getAllAds() {
        return new AdsDto();
    }

    @Override
    public AdDto createAd(CreateOrUpdateAdDto createOrUpdateAdDto, byte[] imageBytes) {
        return new AdDto();
    }

    @Override
    public ExtendedAdDto getAdById(int id) {
        return null;
    }

    @Override
    public void deleteAd(int id) {
    }

    @Override
    public AdDto updateAd(int id, CreateOrUpdateAdDto adDto) {
        return null;
    }

    @Override
    public AdsDto getAdsForCurrentUser() {
        return null;
    }

    @Override
    public void updateAdImage(int id, byte[] imageBytes) {
       }
}
