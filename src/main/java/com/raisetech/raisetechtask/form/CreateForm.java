package com.raisetech.raisetechtask.form;

import lombok.Getter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;

@Getter
public class CreateForm {

    @NotBlank
    private String name;

    @Range(min = 1, max = 130)
    private Integer age;
}
