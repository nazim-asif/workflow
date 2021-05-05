package com.workflow.api.repository.jpa;

import com.workflow.api.domain.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Abdur Rahim Nishad
 * @since 1.0.0
 */
@Repository
public interface ConfigurationRepository extends JpaRepository<Configuration, Long> {
}
