package com.yoon.persistence;

import org.springframework.data.repository.CrudRepository;

import com.yoon.domain.Member;

public interface MemberRepository extends CrudRepository<Member, String> {

}
