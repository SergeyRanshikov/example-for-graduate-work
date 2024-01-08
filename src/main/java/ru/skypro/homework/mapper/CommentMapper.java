package ru.skypro.homework.mapper;

import org.springframework.stereotype.Component;
import ru.skypro.homework.dto.CommentDto;
import ru.skypro.homework.dto.CreateOrUpdateCommentDto;
import ru.skypro.homework.model.Comment;

@Component
public class CommentMapper {
    public static CommentDto commentToCommentDto(Comment comment) {
        CommentDto dto = new CommentDto();
        dto.setPk(comment.getId());
        dto.setCreatedAt(comment.getCreatedAt());
        dto.setText(comment.getText());
        dto.setAuthor(comment.getAuthor().getId());
        dto.setAuthorFirstName(comment.getAuthor().getFirstName());
        dto.setAuthorImage(comment.getAuthor().getImageUrl());
        return dto;
    }

    public static CreateOrUpdateCommentDto createOrUpdateDtoFromComment(Comment entity) {
        CreateOrUpdateCommentDto dto = new CreateOrUpdateCommentDto();
        dto.setText(entity.getText());
        return dto;
    }
}