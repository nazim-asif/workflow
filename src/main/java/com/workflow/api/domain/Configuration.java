package com.workflow.api.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * @author Nazim Uddin Asif
 * @since 1.0.0
 */
@Getter
@Setter
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "configurations")
public class Configuration {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "maker_id", nullable = false)
    private Maker maker;

    private String department;

    private String label;

    @Enumerated(EnumType.STRING)
    private LabelLogic labelLogic;

    private int maxCheckerNo;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "configuration_id")
    private List<Checker> checkers;

    @OneToMany(mappedBy = "configuration")
    private Set<Mapper> mappers;

}
