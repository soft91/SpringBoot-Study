package com.yoon.service;

import org.springframework.data.domain.Page;

import com.yoon.domain.Board;
import com.yoon.domain.Search;

public interface BoardService {
	void insertBoard(Board board);
	void updateBoard(Board board);
	void deleteBoard(Board board);
	
	Board getBoard(Board board);
	
	Page<Board> getBoardList(Search search);
}
