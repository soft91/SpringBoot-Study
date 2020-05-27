package com.yoon.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Board
 *
 */
@Entity
/*
 * 테이블 전략
@TableGenerator(name = "BOARD_SEQ_GENERATOR",
				table = "ALL_SEQUENCES",
				pkColumnName = "BOARD_SEQ",
				initialValue = 0,
				allocationSize = 1)
				*/
@SequenceGenerator(name = "BOARD_SEQ_GENERATOR",
					sequenceName = "BOARD_SEQUENCES",
					initialValue = 1,
					allocationSize = 1)
public class Board {
	@Id
	// @GeneratedValue(strategy = GenerationType.TABLE, generator = "BOARD_SEQ_GENERATOR") 테이블 전략
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOARD_SEQ_GENERATOR")
	private Long seq;
	private String title;
	private String writer;
	private String content;
	@Temporal(TemporalType.DATE)
	private Date createDate;
	private Long cnt;
	public Long getSeq() {
		return seq;
	}
	public void setSeq(Long seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Long getCnt() {
		return cnt;
	}
	public void setCnt(Long cnt) {
		this.cnt = cnt;
	}
	
	@Override
	public String toString() {
		return "Board [seq=" + seq + ", title=" + title + ", writer=" + writer + ", content=" +
				content + ", createDate=" + createDate + ", cnt=" + cnt + "]";
	}
}