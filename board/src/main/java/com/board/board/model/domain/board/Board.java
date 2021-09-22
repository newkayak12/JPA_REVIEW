package com.board.board.model.domain.board;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@Entity

public class Board {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long boardNumber;

	@Column
	String userNickname;

	@Column(length = 500, nullable = false)
	String title;
	
	@Column(columnDefinition = "text", nullable = false)
	String content;
	
	public void update (String title, String content){
		this.title = title;
		this.content = content;
	}
	
	@Builder
	public Board(String userNickname, String title, String content){
		this.userNickname = userNickname;
		this.title = title;
		this.content = content;
	}

}
