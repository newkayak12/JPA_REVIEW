package com.board.board.web.dto;

import com.board.board.model.domain.board.Board;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class BoardDto {
	private long boardNumber;
	String userNickname, title, content;

	public BoardDto(Board board){
		this.boardNumber = board.getBoardNumber();
		this.userNickname = board.getUserNickname();
		this.title = board.getTitle();
		this.content = board.getContent();
	}

	public Board toEntity(){
		return Board.builder().userNickname(userNickname).title(title).content(content).build();
	}
	
}
