package org.lah.WelfareFeeding.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.lah.Commons.domain.User;
import org.lah.WelfareFeeding.annotation.UserAuthority;
import org.lah.WelfareFeeding.exception.ForbiddenException;
import org.lah.WelfareFeeding.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@Aspect
@Component
public class ServiceExceptionAspect {
    private final UserService userService;

    public ServiceExceptionAspect(UserService userService) {
        this.userService = userService;
    }

    // 静态的日志类LogFactory
    private static final Log logger = LogFactory.getLog(ServiceExceptionAspect.class);

    /**
     * 记录异常触发人员
     * @param joinPoint 连接点
     */
    @AfterThrowing(value = "execution(* org.lah.WelfareFeeding.service..*(..))",
        throwing = "throwable")
    public void ValidateAuthority(JoinPoint joinPoint, Throwable throwable) {
        logger.error(userService.getUser(), throwable);
    }
}
