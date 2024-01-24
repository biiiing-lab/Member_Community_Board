package com.example.member_coummunity_board.Repository;

import com.example.member_coummunity_board.Dto.JoinDto;
import com.example.member_coummunity_board.Entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String> {
}
