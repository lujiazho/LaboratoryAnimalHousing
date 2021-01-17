package org.lah.WelfareFeeding.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.lah.Commons.domain.User;
import org.lah.Logistics.controller.CleaningController;
import org.lah.WelfareFeeding.annotation.UserAuthority;
import org.lah.WelfareFeeding.exception.ForbiddenException;
import org.lah.WelfareFeeding.service.UserService;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@Aspect
@Component
public class PreControllerAspect {
    private final UserService userService;

    public PreControllerAspect(UserService userService) {
        this.userService = userService;
    }

    // 静态的日志类LogFactory
    private static final Log logger = LogFactory.getLog(PreControllerAspect.class);

    /**
     * 检查所有福利喂养部分的用户权限，只有特定部门和职位的人员可以调用
     * @param proceedingJoinPoint 连接点
     * @return 原返回值
     * @throws Throwable 任意异常
     */
    @Around("execution(* org.lah.WelfareFeeding.controller..*(..))")
    public Object ValidateAuthority(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        Method method = signature.getMethod();
        Annotation[] annotations = method.getAnnotations();
        User user = userService.getUser();
        boolean flag = false;
        for(Annotation annotation : annotations){
            if(annotation instanceof UserAuthority){
                if(user.getDepartment().equals(((UserAuthority) annotation).department()) || ((UserAuthority) annotation).department().equals("*")){
                    if(user.getPosition().equals(((UserAuthority) annotation).position()) || ((UserAuthority) annotation).position().equals("*")){
                        flag = true;
                        break;
                    }
                }
            }
        }
        if(!flag){
            throw new ForbiddenException();
        }
        return proceedingJoinPoint.proceed();
    }
}
