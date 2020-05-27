package com.yoon;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import com.querydsl.core.BooleanBuilder;
import com.yoon.domain.Board;
import com.yoon.domain.QBoard;
import com.yoon.persistence.DynamicBoardRepositroy;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DynimicQueryTest {
	@Autowired
	private DynamicBoardRepositroy boardRepo;
	
	@Test
	public void testDynamicQuery() {
		String searchCondition = "CONTENT";
		String searchKeyword   = "테스트 제목10";
		
		BooleanBuilder builder = new BooleanBuilder();
		
		QBoard qboard = QBoard.board;
		
		if(searchCondition.equals("TITLE")) {
			builder.and(qboard.title.like("%" + searchKeyword + "%"));
		} else if(searchCondition.equals("CONTENT")) {
			builder.and(qboard.content.like("%" + searchKeyword + "%"));
		}
		
		Pageable paging = PageRequest.of(0, 5);
		
		Page<Board> boardList = boardRepo.findAll(builder, paging);
		
		System.out.println();
		for(Board board: boardList) {
			System.out.println("---> " + board.toString());
		}
	}
}
