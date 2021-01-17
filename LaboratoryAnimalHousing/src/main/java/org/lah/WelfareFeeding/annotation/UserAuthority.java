package org.lah.WelfareFeeding.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 表示Controller方法的权限
 * 如果框架升级到Java8及以上建议使用可重复注解
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface UserAuthority {
    /**
     * 部门
     * @return 部门
     */
    String department();

    /**
     * 职位
     * @return 职位
     */
    String position();
}
