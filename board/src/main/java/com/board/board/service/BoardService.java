package com.board.board.service;

import java.util.List;

import com.board.board.web.dto.BoardDto;

public interface BoardService {
	public List<BoardDto> getBoardList();

	public BoardDto getBoartdOne(Long boardNumber);

	public int boardChecker(Long boardNumber);

	public int updateBoard(BoardDto dto);

	public int deleteBoard(Long boardNumber);

	public int postBoard(BoardDto dto);
}
