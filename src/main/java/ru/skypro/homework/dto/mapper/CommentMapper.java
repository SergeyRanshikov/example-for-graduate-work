package ru.skypro.homework.dto.mapper;

import ru.skypro.homework.dto.CommentDto;
import ru.skypro.homework.dto.CreateOrUpdateCommentDto;
import ru.skypro.homework.model.Comment;

public class CommentMapper {

    public static CommentDto commentToCommentDto(Comment comment) {
        CommentDto dto = new CommentDto();
        dto.setPk(comment.getId());
        dto.setAuthor(comment.getAuthor().getId());
        dto.setAuthorFirstName(comment.getAuthor().getFirstName());
        dto.setAuthorImage(comment.getAuthor().getImage());
        dto.setCreatedAt(comment.getCreatedAt().toString());
        dto.setText(comment.getText());
        return dto;
    }

    public static Comment createOrUpdateCommentFromDto(CreateOrUpdateCommentDto dto) {
        Comment comment = new Comment();
        comment.setText(dto.getText());
        return comment;
    }
}
