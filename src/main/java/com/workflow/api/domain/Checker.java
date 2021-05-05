package com.workflow.api.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.awt.*;

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
@Table(name = "checker")
public class Checker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String role;
    private String name;
    private Boolean isOnline;
    private String access;
    private int checkerNo;
    @Enumerated(EnumType.STRING)
    private CheckerStatus status;
    private String notification;
}
