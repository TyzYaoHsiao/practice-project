package com.ziyao.demo.redis.aspect;

import com.ziyao.demo.core.api.model.req.RequestEntity;
import com.ziyao.demo.core.constant.ApiConst;
import com.ziyao.demo.core.domain.UserProfile;
import com.ziyao.demo.core.util.HttpContextUtil;
import com.ziyao.demo.core.util.RequestUtil;
import com.ziyao.demo.redis.service.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
@Order(value = 3)
@RequiredArgsConstructor
public class RedisAuthAspect {

    private final UserProfile userProfile;
    private final AuthService authService;

    /**
     * 攔截點
     *
     * @param joinPoint
     */
    @Before(value = "com.ziyao.demo.aop.pointcut.PointcutDefinition.restLayer()")
    public void authValid(JoinPoint joinPoint) {
        HttpServletRequest httpServletRequest = HttpContextUtil.getHttpServletRequest();
        if (RequestUtil.isSkip()) {
            return;
        }

        userProfile.setUserId("demo");
        apiInfo(joinPoint, httpServletRequest);
        validToken();
    }

    private void validToken() {
        HttpServletRequest httpServletRequest = HttpContextUtil.getHttpServletRequest();
        String token = httpServletRequest.getHeader(ApiConst.TOKEN_HEADER_NAME);

        // TODO TOKEN驗證
    }

    /**
     * api 資訊
     *
     * @param joinPoint
     */
    private void apiInfo(JoinPoint joinPoint, HttpServletRequest httpServletRequest) {

        Object[] args = joinPoint.getArgs();
        if (args != null) {
            for (Object object : args) {
                if (object instanceof RequestEntity requestEntity) {
                    userProfile.setTxnSeq(requestEntity.getTxnSeq());
                    userProfile.setClientIp(RequestUtil.getIpAddr(httpServletRequest));
                }
            }
        }
    }
}
