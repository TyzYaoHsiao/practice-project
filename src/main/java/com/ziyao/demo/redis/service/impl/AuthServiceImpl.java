package com.ziyao.demo.redis.service.impl;

import com.ziyao.demo.redis.model.req.GetTokenReq;
import com.ziyao.demo.redis.model.res.GetTokenRes;
import com.ziyao.demo.redis.repository.AuthRepository;
import com.ziyao.demo.redis.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthRepository authRepository;

    @Override
    public GetTokenRes getToken(GetTokenReq getTokenReq) {
        // 驗證身分

        String token = UUID.randomUUID().toString();
        authRepository.saveToken(token);
        return GetTokenRes.builder()
                .token(token)
                .build();
    }
}
