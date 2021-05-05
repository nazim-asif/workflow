package com.workflow.api.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.workflow.api.domain.CheckerStatus;
import com.workflow.api.service.WorkflowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.InvocationTargetException;

/**
 * @author Nazim Uddin Asif
 * @since 1.0.0
 */
@RestController
@RequestMapping("api/workflow/")
public class WorkflowController {
    @Autowired
    private WorkflowService workflowService;

    @GetMapping("maker/verification/{configurationId}")
    public void getMakerVerification(@PathVariable Long configurationId){
        workflowService.getMakerVerification(configurationId);
    }

    @GetMapping("checker/approval/{configurationId}/{checkerStatus}")
    public void getCheckerApproval(@PathVariable Long configurationId,@PathVariable CheckerStatus checkerStatus){
        workflowService.getCheckerApproval(configurationId, checkerStatus);
    }
    @GetMapping("test/{configurationId}")
    public void getChecker(@PathVariable long configurationId) throws IllegalAccessException, InvocationTargetException, JsonProcessingException, InstantiationException, NoSuchMethodException, ClassNotFoundException {
        workflowService.getChecker(configurationId);
    }


}
