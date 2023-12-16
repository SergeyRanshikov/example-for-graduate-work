package ru.skypro.homework.service.impl;

import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.CommentDto;
import ru.skypro.homework.dto.CommentsDto;
import ru.skypro.homework.dto.CreateOrUpdateCommentDto;
import ru.skypro.homework.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

    @Override
    public CommentsDto getComments(int adId) {
        return null;
    }

    @Override
    public CommentDto addComment(int adId, CreateOrUpdateCommentDto commentDto) {
        return null;
    }

    @Override
    public void deleteComment(int adId, int commentId) {
        }

    @Override
    public CommentDto updateComment(int adId, int commentId, CreateOrUpdateCommentDto commentDto) {
        return null;
    }
}
