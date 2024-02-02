package com.example.member_coummunity_board.Repository;
import com.example.member_coummunity_board.DTO.MemberResponseDto;
import com.example.member_coummunity_board.Domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MemberRepository extends JpaRepository<Member, Long> {
    MemberResponseDto findByMemberIdAndPassword(String memberId, String password);

    String findByMemberId(String memberId);
    String findByPassword(String memberId);

}
