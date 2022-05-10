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
@Table(name="USER")
public class User extends AbstractEntity {

    @JoinColumn(name = "ROLE")
    @OneToMany(cascade = CascadeType.ALL)
    @NotNull(message = "Role cannot be null")
    @Min(value = 1, message = "Role must be at least 1 or bigger")
    private List<Role> role;

    @Column(name = "EMAIL")
    @NotNull(message = "Email cannot be null")
    private String email;

    @Column(name = "PASSWORD")
    @NotNull(message = "Email cannot be null")
    private String password;

    @Column(name = "CONFIRMED")
    @NotNull(message = "confirmed cannot be null")
    private boolean confirmed;
}
