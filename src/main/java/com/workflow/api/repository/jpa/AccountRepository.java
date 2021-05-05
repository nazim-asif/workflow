package com.workflow.api.repository.jpa;

import com.workflow.api.repository.schema.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Abdur Rahim Nishad
 * @since 1.0.0
 */
@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {
}
