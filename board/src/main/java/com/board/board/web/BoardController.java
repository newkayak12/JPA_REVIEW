package com.board.board.web;

import com.board.board.service.BoardService;
import com.board.board.web.dto.BoardDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardController {
	@Autowired
	BoardService service;

	@PutMapping("/api/v1/board")
	public int updateBoard(@RequestBody BoardDto dto){
		return service.updateBoard(dto);
	}

	@DeleteMapping("/api/v1/board/{boardNumber}")
	public int deleteBoard(@PathVariable Long boardNumber){
		return service.deleteBoard(boardNumber);
	}

	@PostMapping("/api/v1/board")
	public int postBoard(@RequestBody BoardDto dto){
		return service.postBoard(dto);
	}
}
