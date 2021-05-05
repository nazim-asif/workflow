package com.workflow.api.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Set;

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
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private int priority;
    @Enumerated(EnumType.STRING)
    private TaskState state;
    private String payload;
    @OneToMany(mappedBy = "task")
    Set<Mapper> mappers;

}
