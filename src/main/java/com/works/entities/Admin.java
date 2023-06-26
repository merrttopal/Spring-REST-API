package com.works.entities;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
@Data
public class Admin {

    @Id
    private Integer aid;


    @Email
    @NotNull
    @NotEmpty
    @Column(unique = true)
    private String email;

    @Size(min = 5, max = 8)
    @Length(min = 5, max = 8)
    @NotEmpty
    @NotNull
    private String password;

}
