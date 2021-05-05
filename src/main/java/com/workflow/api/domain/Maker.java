package com.workflow.api.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;

/**
 * @author Nazim Uddin Asif
 * @author Abdur Rahim Nishad
 * @since 1.0.0
 */
@Getter
@Setter
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "maker")
public class Maker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String role;
    private String department;
    @Enumerated(EnumType.STRING)
    private MakerStatus status;
    private String notification;
}
