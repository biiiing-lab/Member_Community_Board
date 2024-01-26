package com.example.member_coummunity_board.Repository;

import com.example.member_coummunity_board.Domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {

}
