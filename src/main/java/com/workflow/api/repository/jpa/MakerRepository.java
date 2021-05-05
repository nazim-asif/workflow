package com.workflow.api.repository.jpa;

import com.workflow.api.domain.Maker;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Nazim Uddin Asif
 * @since 1.0.0
 */
public interface MakerRepository extends JpaRepository<Maker, Long> {
}
