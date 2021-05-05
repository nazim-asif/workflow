package com.workflow.api.repository.jpa;

import com.workflow.api.domain.Checker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Abdur Rahim Nishad
 * @author Nazim Uddin Asif
 * @since 1.0.0
 */
@Repository
public interface CheckerRepository extends JpaRepository<Checker, Long> {
    Checker findCheckerByCheckerNo(int id);
}
