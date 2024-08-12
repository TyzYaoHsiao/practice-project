package com.ziyao.demo.core.aop.aspect;

import com.ziyao.demo.core.constant.SysConst;
import org.apache.commons.lang3.RandomStringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.MDC;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * trace id
 */
@Aspect
@Component
@Order(1)
public class TraceIDAspect {

    /**
     * add log trace id
     *
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around(value = "com.ziyao.demo.core.aop.pointcut.PointcutDefinition.restLayer()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        MDC.put(SysConst.TRACE_ID_KEY, RandomStringUtils.randomAlphanumeric(SysConst.TRACE_ID_KEY_LENGTH));
        return joinPoint.proceed();
    }

}
