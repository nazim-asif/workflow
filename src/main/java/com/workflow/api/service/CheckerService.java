package com.workflow.api.service;

import com.workflow.api.repository.jpa.CheckerRepository;
import org.springframework.stereotype.Service;

/**
 * @author Abdur Rahim Nishad
 * @since 1.0.0
 */
@Service
public class CheckerService {
    private final CheckerRepository checkerRepository;

    public CheckerService(CheckerRepository checkerRepository) {
        this.checkerRepository = checkerRepository;
    }
}
