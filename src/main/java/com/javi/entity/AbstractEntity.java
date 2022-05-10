package com.javi.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    @Column(name = "ID")
    @NotNull(message = "Id cannot be null")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Min(value = 1, message = "Id must be at least 1 or bigger")
    protected long id;

    @Column(name = "NAME")
    @NotNull(message = "Name cannot be null")
    public String name;

    @Column(name = "DESCRIPTION")
    public String description;
}
