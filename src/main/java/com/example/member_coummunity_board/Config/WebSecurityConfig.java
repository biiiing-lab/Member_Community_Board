
package com.example.member_coummunity_board.Config;

import com.example.member_coummunity_board.Jwt.JwtProperties;
import com.example.member_coummunity_board.Service.MemberService;
import jakarta.servlet.DispatcherType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Bag;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import java.security.PublicKey;
import java.util.stream.Stream;

import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;
import static org.springframework.security.config.http.MatcherType.ant;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfig {
    private static final String[] WHITE_LIST = {
            "/helloWorld",
    };
    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder =
                http.getSharedObject(AuthenticationManagerBuilder.class);
        return authenticationManagerBuilder.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
    @Bean
    public MvcRequestMatcher.Builder mvcRequestMatcherBuilder(HandlerMappingIntrospector introspector) {
        return new MvcRequestMatcher.Builder(introspector);
    }

    // security 설정
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, MvcRequestMatcher.Builder mvc) throws Exception {
        http

                .sessionManagement(sessionManagement -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .csrf(AbstractHttpConfigurer::disable) // html 보안 X
                .cors(AbstractHttpConfigurer::disable)

                .headers(c -> c.frameOptions(HeadersConfigurer
                                .FrameOptionsConfig::disable)
                        .disable()) // h2 DB 사용

                .authorizeHttpRequests(request -> request
                        .requestMatchers(PathRequest.toH2Console()).permitAll()
                        .requestMatchers("/", "/Login", "/SignUp", "/logout").permitAll()
                        .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
                        .anyRequest().authenticated()
                )



                .formLogin(login -> login
                        .loginPage("/Login")
                        .defaultSuccessUrl("/Home", true)
                        .permitAll())

                .logout(logout -> logout
                        .logoutSuccessUrl("/Login")
                        .invalidateHttpSession(true)
                        .deleteCookies(JwtProperties.COOKIE_NAME));

        return http.build();
    }
    private MvcRequestMatcher[] createMvcRequestMatcherForWhitelist(MvcRequestMatcher.Builder mvc) {
        return Stream.of(WHITE_LIST).map(mvc::pattern).toArray(MvcRequestMatcher[]::new);
    }
}