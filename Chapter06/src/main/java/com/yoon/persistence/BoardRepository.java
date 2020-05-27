package com.yoon.persistence;

import org.springframework.data.repository.CrudRepository;

import com.yoon.domain.Board;

public interface BoardRepository extends CrudRepository<Board, Long> {

}
