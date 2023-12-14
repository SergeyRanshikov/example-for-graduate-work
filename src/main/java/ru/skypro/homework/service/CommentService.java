package ru.skypro.homework.service;

import ru.skypro.homework.dto.Comment;
import ru.skypro.homework.dto.Comments;
import ru.skypro.homework.dto.CreateOrUpdateComment;

public interface CommentService {
    Comments getComments(int adId) throws Exception;
    Comment addComment(int adId, CreateOrUpdateComment commentDto) throws Exception;
    void deleteComment(int adId, int commentId) throws Exception;
    Comment updateComment(int adId, int commentId, CreateOrUpdateComment commentDto) throws Exception;}
