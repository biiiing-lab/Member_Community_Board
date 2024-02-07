package com.example.member_coummunity_board.Repository;
import com.example.member_coummunity_board.DTO.MemberResponseDto;
import com.example.member_coummunity_board.Domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;

import java.util.Optional;


public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByMemberId(String memberId);
}
