package ru.skypro.homework.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.AdDto;
import ru.skypro.homework.dto.AdsDto;
import ru.skypro.homework.dto.CreateOrUpdateAdDto;
import ru.skypro.homework.dto.ExtendedAdDto;
import ru.skypro.homework.dto.mapper.AdMapper;
import ru.skypro.homework.exception.AccessDeniedException;
import ru.skypro.homework.exception.AdNotFoundException;
import ru.skypro.homework.model.Ad;
import ru.skypro.homework.model.Image;
import ru.skypro.homework.repository.AdRepository;
import ru.skypro.homework.service.AdService;
import ru.skypro.homework.service.ImageService;
import ru.skypro.homework.service.UserService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class AdServiceImpl implements AdService {
    private final AdRepository adRepository;
    private final ImageService imageService;
    private final UserService userService;
    @Override
    public AdsDto getAllAds() {
        List<AdDto> allAds = adRepository.findAll().stream()
                .map(AdMapper::adToAdDto)
                .collect(Collectors.toList());
        return new AdsDto(allAds.size(), allAds);
    }

    @Override
    public AdDto addAd(CreateOrUpdateAdDto properties, MultipartFile image, Authentication authentication) throws IOException {
        if (authentication.isAuthenticated()) {
            Image newImage = imageService.saveToDataBase(image);
            Ad adEntity = AdMapper.createOrUpdateAdFromDto(properties);
            adEntity.setAuthor(userService.findByEmail(authentication.getName()));
            adEntity.setImage(newImage);
            adEntity.setImageUrl("/images/" + newImage.getId());
            adRepository.save(adEntity);
            return AdMapper.adToAdDto(adEntity);
        } else {
            throw new RuntimeException();
        }
    }

    @Override
    public ExtendedAdDto getAdById(Integer id, Authentication authentication) {
        if (authentication.isAuthenticated()) {
            Ad ad = adRepository.findById(id).orElseThrow(AdNotFoundException::new);
            return AdMapper.adToExtendedAdDto(ad);
        } else {
            throw new RuntimeException();
        }
    }
    @Override
    public void deleteAd(Integer id, Authentication authentication) {
        Ad deletedAd = adRepository.findById(id).orElseThrow(AdNotFoundException::new);
        Image deletedImage = imageService.findById(deletedAd.getImage().getId());
        String deletedAdAuthorName = deletedAd.getAuthor().getEmail();
        if (ValidationService.isAdmin(authentication) || ValidationService.isOwner(authentication, deletedAdAuthorName)) {
            adRepository.delete(deletedAd);
            imageService.deleteImage(deletedImage);
        } else {
            throw new AccessDeniedException();
        }
    }

    @Override
    public AdDto updateAd(Integer id, CreateOrUpdateAdDto newProperties, Authentication authentication) {
        Ad updatedAd = adRepository.findById(id).orElseThrow(AdNotFoundException::new);
        String updatedAdAuthorName = updatedAd.getAuthor().getEmail();
        if (ValidationService.isAdmin(authentication) || ValidationService.isOwner(authentication, updatedAdAuthorName)) {
            Optional.ofNullable(newProperties.getPrice()).ifPresent(updatedAd::setPrice);
            Optional.ofNullable(newProperties.getTitle()).ifPresent(updatedAd::setTitle);
            Optional.ofNullable(newProperties.getDescription()).ifPresent(updatedAd::setDescription);
            adRepository.save(updatedAd);
            return AdMapper.adToAdDto(updatedAd);
        } else {
            throw new AccessDeniedException();
        }
    }

    @Override
    public void updateImage(Integer id, MultipartFile image, Authentication authentication) {
        String adAuthorName = adRepository.findById(id).orElseThrow(AdNotFoundException::new).getAuthor().getEmail();
        if (ValidationService.isAdmin(authentication) || ValidationService.isOwner(authentication, adAuthorName)) {
            Ad ad = adRepository.findById(id).orElseThrow(AdNotFoundException::new);
            imageService.deleteImage(ad.getImage());
            try {
                Image newImage = imageService.saveToDataBase(image);
                ad.setImage(newImage);
                ad.setImageUrl("/images/" + newImage.getId());
                adRepository.save(ad);
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        } else {
            throw new AccessDeniedException();
        }
    }

    @Override
    public AdsDto getMyAds(Authentication authentication) {
        Integer myId = userService.findByEmail(authentication.getName()).getId();
        List<AdDto> allMyAds = adRepository.findAll().stream()
                .filter(ad -> ad.getAuthor().getId().equals(myId))
                .map(AdMapper::adToAdDto)
                .collect(Collectors.toList());
        return new AdsDto(allMyAds.size(), allMyAds);
    }
    @Override
    public Ad getById(Integer id) {
        return adRepository.findById(id).orElseThrow(AdNotFoundException::new);
    }

    @Override
    public Ad createAd(Ad ad) {
        return adRepository.save(ad);
    }


}
