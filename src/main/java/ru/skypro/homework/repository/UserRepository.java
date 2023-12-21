package ru.skypro.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.skypro.homework.model.User;
import ru.skypro.homework.model.Ad;
import ru.skypro.homework.model.Comment;

public interface UserRepository extends JpaRepository<User, Integer> {
}
