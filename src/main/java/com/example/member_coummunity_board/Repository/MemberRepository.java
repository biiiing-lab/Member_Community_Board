package com.example.member_coummunity_board.Repository;

import com.example.member_coummunity_board.Entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;

public interface MemberRepository extends JpaRepository<Member, String> {
    User findByMember(String memberId);
}
