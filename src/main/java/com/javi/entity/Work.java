package com.javi.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.List;

@Valid
@Entity
@Getter
@Setter
@ToString
@JsonSerialize
@NoArgsConstructor
@Table(name="WORK")
public class Work extends AbstractEntity {

    @JoinColumn(name = "ROLE")
    @ManyToOne(cascade = CascadeType.ALL)
    @NotNull(message = "Role cannot be null")
    private Role role;

    @Column(name = "START")
    @NotNull(message = "Start time cannot be null")
    private Timestamp start;

    @Column(name = "END")
    @NotNull(message = "End time cannot be null")
    private Timestamp end;

    @Column(name = "PROJECT")
    @NotNull(message = "Project cannot be null")
    private long project;
}
