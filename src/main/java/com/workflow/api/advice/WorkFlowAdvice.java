package com.workflow.api.advice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.workflow.api.domain.Instance;
import com.workflow.api.domain.Status;
import com.workflow.api.repository.jpa.InstanceRepository;
import com.workflow.api.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author Abdur Rahim Nishad
 * @since 1.0.0
 */
@Aspect
@Component
@Slf4j
public class WorkFlowAdvice {

    private final InstanceRepository instanceRepository;

    //    @Autowired
//    private AccountService accountService;
    public WorkFlowAdvice(InstanceRepository instanceRepository) {
        this.instanceRepository = instanceRepository;
    }


    @Around("@annotation(com.workflow.api.annotation.EnableWorkFlow)")
    public Object trackTime(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("Method " + pjp.getSignature().getName());
        System.out.println("Method " + pjp.getSignature().getDeclaringTypeName());
        Object[] args = pjp.getArgs();
        String str = "";
        for (Object signatureArg : args) {
            str = signatureArg + "#";
            System.out.println("Arguments are : " + signatureArg);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        String serialized = objectMapper.writeValueAsString(str);
        System.out.println(serialized);

//            Deserialized
//        Object obj = objectMapper.readValue(serialized, Object.class);
//        System.out.println(obj);

        Instance instance = instanceRepository.findByPayload(serialized);

        Object obj = null;
        if(Objects.isNull(instance) || instance.getStatus()!= Status.APPROVED ||  Objects.nonNull(instance.getPayload()) ){
            Instance instance1 = new Instance();
            instance1.setName(pjp.getSignature().getName())
                    .setPayload(serialized)
                    .setEventName(pjp.getSignature().getName())
                    .setStatus(Status.ACTIVE)
                    .setDescription(pjp.getSignature().getDeclaringTypeName())
                    .setStartAt(LocalDateTime.now());
            instanceRepository.save(instance1);
        }
        else if (instance.getStatus() == Status.APPROVED) {
            instance.setPayload(null);
            instanceRepository.save(instance);
            obj = pjp.proceed();
        }
        System.out.println(obj);
        return obj;
    }
}
