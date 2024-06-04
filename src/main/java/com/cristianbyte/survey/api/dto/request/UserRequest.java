package com.cristianbyte.survey.api.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    @Size(min = 5, max = 100, message = "the name must be at least 5 characters and not more than 100 characters")
    private String name;
    @Email(message = "invalid email address")
    private String email;
    @Size(min = 5, max = 100, message = "the password must be at least 5 characters and not more than 100 characters")
    private String password;
    @NotNull(message="you must define a status with active")
    private boolean active;
}
