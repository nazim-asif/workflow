package com.workflow.api.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.workflow.api.domain.*;
import com.workflow.api.repository.jpa.ConfigurationRepository;
import com.workflow.api.repository.jpa.InstanceRepository;
import com.workflow.api.repository.jpa.MapperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Optional;

/**
 * @author Nazim Uddin Asif
 * @since 1.0.0
 */
@Service
public class WorkflowService {
    @Autowired
    private ConfigurationRepository configurationRepository;
    @Autowired
    private MapperRepository mapperRepository;
    @Autowired
    private InstanceRepository instanceRepository;

    public void getMakerVerification(Long configurationId) {
        Configuration configuration = configurationRepository.findById(configurationId).get();
        configuration.getMaker().setStatus(MakerStatus.PASS);
        alarNextChecker(configuration, 1);
        configurationRepository.save(configuration);
    }

    public void getCheckerApproval(Long configurationId, CheckerStatus checkerStatus) {
        Configuration configuration = configurationRepository.findById(configurationId).get();
        Mapper mapper = mapperRepository.findByConfigurationId(configurationId);
        Instance instance = instanceRepository.findByMapperId(mapper.getId());
        List<Checker> checkers = configuration.getCheckers();
        for (Checker checker : checkers) {
            if (checker.getStatus().equals(CheckerStatus.PENDING) && checkerStatus.equals(CheckerStatus.APPROVED)) {
                checker.setStatus(checkerStatus)
                        .setNotification("Your Task is ready");
                alarNextChecker(configuration, checker.getCheckerNo() + 1);
                break;
            } else if (checker.getStatus().equals(CheckerStatus.PENDING) && checkerStatus.equals(CheckerStatus.REJECT)) {
                configuration.getMaker().setNotification("Your Task is rejected");
            }
            if (configuration.getMaxCheckerNo() == checker.getCheckerNo() && checkerStatus.equals(CheckerStatus.APPROVED)) {
                String s = instance.getPayload();
                System.out.println(s);

                //getChecker(instance);
                //TODO Instance Payload Data will be saved to customer
                configuration.getMaker().setNotification("Your Task is Approved");
            }
        }
        configurationRepository.save(configuration);
    }

    public void alarNextChecker(Configuration configuration, int checkerNo) {
        List<Checker> checkers = configuration.getCheckers();
        for (Checker checker : checkers) {
            if (checker.getCheckerNo() == checkerNo) {
                checker.setStatus(CheckerStatus.PENDING)
                        .setNotification("Your Task Arrived. Please Check");
                break;
            }
        }
        configurationRepository.save(configuration);
    }


    public void getChecker(Long instanceId) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, JsonProcessingException, InvocationTargetException {
        Optional<Instance> instance = instanceRepository.findById(instanceId);
//        String packageName = instance.get().getDescription();

        String packageName = "com.workflow.api.service.AccountService";
        Class<?> packageClass = Class.forName(packageName);
        Object p = packageClass.newInstance();
        String methodName = instance.get().getName();
        Method setNameMethod = p.getClass().getMethod(methodName, Object.class);

        ObjectMapper objectMapper = new ObjectMapper();
        Object obj = objectMapper.readValue(instance.get().getPayload(), Object.class);
        setNameMethod.invoke(p, obj);
        System.out.println("--> test : " + obj);


    }
}
