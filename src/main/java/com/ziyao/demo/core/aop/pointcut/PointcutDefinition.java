package com.ziyao.demo.core.aop.pointcut;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutDefinition {
    @Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
    public void restLayer(){}
}
