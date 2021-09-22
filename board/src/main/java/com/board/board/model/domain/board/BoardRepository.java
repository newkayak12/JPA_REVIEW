package com.board.board.model.domain.board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface BoardRepository extends JpaRepository<Board,Long> {
	@Query(value = "SELECT count(*) from board b where b.board_number=:boardNumber", nativeQuery = true)
	public int boardChecker(@Param("boardNumber") Long boardNumber);
}
