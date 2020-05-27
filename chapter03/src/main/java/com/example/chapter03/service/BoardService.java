package com.example.chapter03.service;

import com.example.chapter03.domain.BoardVO;

import java.util.List;

public interface BoardService {
    String hello(String name);
    BoardVO getBoard();
    List<BoardVO> getBoardList();
}
