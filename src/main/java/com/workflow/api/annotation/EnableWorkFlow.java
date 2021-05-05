package com.workflow.api.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @author Abdur Rahim Nishad
 * @since 1.0.0
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Component
public @interface EnableWorkFlow {
    String value() default "";
}
