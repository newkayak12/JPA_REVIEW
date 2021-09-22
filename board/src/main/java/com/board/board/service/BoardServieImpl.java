package com.board.board.service;

import java.util.List;
import java.util.stream.Collectors;

import com.board.board.model.domain.board.Board;
import com.board.board.model.domain.board.BoardRepository;
import com.board.board.web.dto.BoardDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BoardServieImpl implements BoardService{
@Autowired
BoardRepository repo;
	@Transactional(readOnly=true)
	@Override
	public List<BoardDto> getBoardList() {
		// TODO Auto-generated method stub
		return repo.findAll(Sort.by(Sort.Direction.DESC, "boardNumber")).stream().map(board -> new BoardDto(board)).collect(Collectors.toList());
	}

	@Override
	public BoardDto getBoartdOne(Long boardNumber) {
		Board entity = repo.findById(boardNumber).orElseThrow(() -> new IllegalArgumentException("IllegalAccess"));
			
		return new BoardDto(entity);
	}

	@Transactional
	@Override
	public int updateBoard(BoardDto dto) {
		Board entity = repo.findById(dto.getBoardNumber()).orElseThrow(()-> new IllegalArgumentException("IllegalAcess"));
		entity.update(dto.getTitle(), dto.getContent());
		return repo.boardChecker(dto.getBoardNumber());
	}

	@Transactional
	@Override
	public int deleteBoard(Long boardNumber) {
		// TODO Auto-generated method stub
		repo.deleteById(boardNumber);
		return repo.boardChecker(boardNumber);
	}

	@Transactional(readOnly=true)
	@Override
	public int boardChecker(Long boardNumber) {
		// TODO Auto-generated method stub
		return repo.boardChecker(boardNumber);
	}

	@Override
	public int postBoard(BoardDto dto) {
		Long number = repo.save(dto.toEntity()).getBoardNumber();
		if(number!=0){
			return 1;
		} else {
			return 0;
		}
	}
	
}
