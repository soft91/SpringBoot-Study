package com.yoon.persistence;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import com.yoon.domain.Board;

public interface DynamicBoardRepositroy extends CrudRepository<Board, Long>, QuerydslPredicateExecutor<Board>{

}
