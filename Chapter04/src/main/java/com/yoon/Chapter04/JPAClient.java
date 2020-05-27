package com.yoon.Chapter04;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.yoon.domain.Board;

public class JPAClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			/*
			 * select
			Board searchBoard = em.find(Board.class, 1L);
			System.out.println(searchBoard.toString());
			*/
			// 트렌젝션 시작
			tx.begin();
			
			Board board1 = em.find(Board.class, 1L);
			board1.setSeq(1L);
			
			//삭제
			board1.setSeq(1L);
			em.remove(board1);
			
			
			/*
			 * Board board = em.find(Board.class, 1L); board.setTitle("검색한 게시글의 제목 수정");
			 */
			
			/*
			 * Board board = new Board(); board.setTitle("JPA 제목"); board.setWriter("관리자");
			 * board.setContent("JPA 글 등록 잘 되네요!!"); board.setCreateDate(new Date());
			 * board.setCnt(0L);
			 * 
			 * //글 등록 em.persist(board);
			 */
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
			emf.close();
		}
	}

}
