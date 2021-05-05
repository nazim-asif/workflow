package com.workflow.api.service;

import com.workflow.api.repository.jpa.MapperRepository;
import org.springframework.stereotype.Service;

/**
 * @author Abdur Rahim Nishad
 * @author Nazim Uddin Asif
 * @since 1.0.0
 */
@Service
public class MapperService {
    private final MapperRepository mapperRepository;

    public MapperService(MapperRepository mapperRepository) {
        this.mapperRepository = mapperRepository;
    }
}
