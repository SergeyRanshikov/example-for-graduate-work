package ru.skypro.homework.service;

import ru.skypro.homework.dto.*;

public interface AdService {
    AdsDto getAllAds();
    AdDto createAd(CreateOrUpdateAdDto createOrUpdateAdDto, byte[] imageBytes);
    ExtendedAdDto getAdById(int id);
    void deleteAd(int id);
    AdDto updateAd(int id, CreateOrUpdateAdDto createOrUpdateAdDto);
    AdsDto getAdsForCurrentUser();
    void updateAdImage(int id, byte[] imageBytes);
}
