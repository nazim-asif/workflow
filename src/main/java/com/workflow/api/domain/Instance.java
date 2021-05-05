package com.workflow.api.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDateTime;

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
@Table(name = "instance")
public class Instance {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private String eventName;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mapper_id")
    private Mapper mapper;

    private int labelTracker;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String payload;

    private String workPlaceName;

    private LocalDateTime startAt;

    private LocalDateTime endAt;
}
