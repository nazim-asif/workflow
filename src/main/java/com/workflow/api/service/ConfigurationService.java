package com.workflow.api.service;

import com.workflow.api.repository.jpa.ConfigurationRepository;
import org.springframework.stereotype.Service;

/**
 * @author Abdur Rahim Nishad
 * @since 1.0.0
 */
@Service
public class ConfigurationService {
    private final ConfigurationRepository configurationRepository;

    public ConfigurationService(ConfigurationRepository configurationRepository) {
        this.configurationRepository = configurationRepository;
    }
}
