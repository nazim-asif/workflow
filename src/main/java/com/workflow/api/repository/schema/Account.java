package com.workflow.api.repository.schema;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.*;

/**
 * @author Abdur Rahim Nishad
 * @since 1.0.0
 */
@Getter
@Setter
@Entity
@ToString
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "account_number")
    private String accountNo;
    @Column(name = "account_name")
    private String accountName;
}
