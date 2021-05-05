package com.workflow.api.service;

import com.workflow.api.repository.jpa.InstanceRepository;
import org.springframework.stereotype.Service;

/**
 * @author Abdur Rahim Nishad
 * @since 1.0.0
 */
@Service
public class InstanceService {
    private final InstanceRepository instanceRepository;

    public InstanceService(InstanceRepository instanceRepository) {
        this.instanceRepository = instanceRepository;
    }
}
