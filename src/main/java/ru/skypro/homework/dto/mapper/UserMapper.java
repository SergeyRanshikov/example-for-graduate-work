package ru.skypro.homework.dto.mapper;

import ru.skypro.homework.dto.RegisterDto;
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
        dto.setPhone(user.getPhone());
        dto.setRole(user.getRole());
        dto.setImage(user.getImage());
        return dto;
    }

    public static User userDtoToUser(UserDto dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setEmail(dto.getEmail());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setPhone(dto.getPhone());
        user.setRole(dto.getRole());
        user.setImage(dto.getImage());
        return user;
    }



    public static void updateUserFromDto(UpdateUserDto dto, User user) {
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setPhone(dto.getPhone());
    }

    public static UpdateUserDto userToUpdateUserDto(User user) {
        UpdateUserDto dto = new UpdateUserDto();
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setPhone(user.getPhone());
        return dto;
    }
    public static RegisterDto userToRegisterDto(User user) {
        RegisterDto dto = new RegisterDto();
        dto.setEmail(user.getEmail()); // Используем email в качестве username для регистрации
        // dto.setPassword(user.getPassword()); // Не следует передавать пароль в DTO
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setPhone(user.getPhone());
        dto.setRole(user.getRole());
        return dto;
    }


    public static User registerDtoToUser(RegisterDto dto) {
        User user = new User();
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setPhone(dto.getPhone());
        user.setRole(dto.getRole());
        return user;
    }



}
