package com.javi.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Valid
@Entity
@Getter
@Setter
@ToString
@JsonSerialize
@NoArgsConstructor
@Table(name="ROLE")
public class Role extends AbstractEntity {

    @JoinColumn(name = "WORK")
    @OneToMany(cascade = CascadeType.ALL)
    @NotNull(message = "Work cannot be null")
    @Min(value = 1, message = "Work must be at least 1 or bigger")
    List<Work> works;
}
