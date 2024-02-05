package com.example.member_coummunity_board.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
// spring data jpa에서 시간에 대해서 자동으로 값을 넣어주는 기능을 사용할 수 있도록 설정
@EnableJpaAuditing
public class JpaAuditingConfig {
}
