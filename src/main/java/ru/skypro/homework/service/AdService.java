package ru.skypro.homework.service;

import org.springframework.security.core.Authentication;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.*;
import ru.skypro.homework.model.Ad;

import java.io.IOException;

public interface AdService {
    AdsDto getAllAds();
    AdDto addAd(CreateOrUpdateAdDto ad, MultipartFile imageBytes, Authentication authentication) throws IOException;
    ExtendedAdDto getAdById(Integer id, Authentication authentication);
    void deleteAd(Integer id, Authentication authentication);
    AdDto updateAd(Integer id, CreateOrUpdateAdDto ad, Authentication authentication);

    void updateImage(Integer id, MultipartFile image, Authentication authentication);

    AdsDto getMyAds(Authentication authentication);

    Ad createAd(Ad ad);

    Ad getById(Integer id);

}
