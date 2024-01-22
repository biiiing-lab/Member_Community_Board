package com.example.member_coummunity_board.Controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class testController {

    @GetMapping("/data-test")
    public String springDataTest(){
        return "스프링에서 보내는 데이터";
        }

}
