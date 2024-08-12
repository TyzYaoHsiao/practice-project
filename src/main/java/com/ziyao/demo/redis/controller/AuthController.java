package com.ziyao.demo.redis.controller;


import com.ziyao.demo.redis.model.req.GetTokenReq;
import com.ziyao.demo.redis.model.res.GetTokenRes;
import com.ziyao.demo.redis.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/redis/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @GetMapping("/getToken")
    public GetTokenRes getToken(@RequestBody GetTokenReq getTokenReq) {
        return authService.getToken(getTokenReq);
    }
}
