package com.team5.fandom.controller.rto.request;


import com.team5.fandom.dto.CommentDto;
import com.team5.fandom.dto.UserDto;
import com.team5.fandom.entity.Post;
import com.team5.fandom.entity.User;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@AllArgsConstructor
public class CommentReqSave {
    private Integer postId;
    private String commentContent;
    
    public static CommentReqSave of(Integer postId, String commentContent) {
    	return new CommentReqSave(postId, commentContent);
    }
    
    public CommentDto toDto(UserDto userDto) {
		return CommentDto.of(postId, 
							 commentContent, 
							 userDto);
	}
    
}
