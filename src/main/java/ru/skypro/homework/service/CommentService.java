package ru.skypro.homework.service;

import org.springframework.security.core.Authentication;
import ru.skypro.homework.dto.CommentDto;
import ru.skypro.homework.dto.CommentsDto;
import ru.skypro.homework.dto.CreateOrUpdateCommentDto;

public interface CommentService {
    CommentsDto getComments(Integer id, Authentication authentication);
    CommentDto addComment(Integer id, Authentication authentication, CreateOrUpdateCommentDto newComment);
    void deleteComment(Integer adId, Integer commentId, Authentication authentication);
    CreateOrUpdateCommentDto updateComment(Integer adId, Integer commentId, CreateOrUpdateCommentDto comment, Authentication authentication);
}
