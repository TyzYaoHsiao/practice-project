package com.ziyao.demo.redis.service;

import com.ziyao.demo.redis.model.req.GetTokenReq;
import com.ziyao.demo.redis.model.res.GetTokenRes;

public interface AuthService {

    GetTokenRes getToken(GetTokenReq getTokenReq);
}
