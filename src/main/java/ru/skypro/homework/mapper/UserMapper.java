package ru.skypro.homework.mapper;

import ru.skypro.homework.dto.UpdateUserDto;
import ru.skypro.homework.dto.UserDto;
import ru.skypro.homework.model.User;

public class UserMapper {

    public static UserDto userToUserDto(User user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setEmail(user.getEmail());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setPhone(user.getPhoneNumber());
        dto.setRole(user.getRole());
        dto.setImage(user.getImageUrl());
        return dto;
    }
    public static UpdateUserDto userUpdateUserDto(User entity) {
        UpdateUserDto dto = new UpdateUserDto();
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setPhone(entity.getPhoneNumber());
        return dto;
    }
}
