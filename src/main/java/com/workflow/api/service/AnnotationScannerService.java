package com.workflow.api.service;

import com.workflow.api.annotation.EnableWorkFlow;
import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author Abdur Rahim Nishad
 * @since 1.0.0
 */
@Component
public class AnnotationScannerService {
    public List<String> getMethods(String basePackage){
        Set<Method> allMethods = new Reflections(basePackage, new MethodAnnotationsScanner()).getMethodsAnnotatedWith(EnableWorkFlow.class);
        List<String> methods = new ArrayList<>();
        for (Method m : allMethods){
            if (m.isAnnotationPresent(EnableWorkFlow.class)) {
//                EnableWorkFlow workFlow = (EnableWorkFlow) m.getAnnotation(EnableWorkFlow.class);
//                AnnotatedMethod annotatedMethod = new AnnotatedMethod(workFlow.value());
                methods.add(m.getName());
            }
        }
        return methods;
    }
}
