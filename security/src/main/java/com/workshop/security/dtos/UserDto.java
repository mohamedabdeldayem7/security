package com.workshop.security.dtos;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.workshop.security.models.constants.Role;
import com.workshop.security.validation.ValidEmail;
import lombok.*;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserDto {

    @NotNull(message = "First name can not be null")
    @Size(message = "First name size not valid", min = 2, max = 12)
    private String firstName;

    @NotNull(message = "Last name can not be null")
    @Size(message = "Last name size not valid", min = 2, max = 12)
    private String lastName;

    @NotNull(message = "Email address can not be null")
    @ValidEmail
    private String email;

    @NotNull(message = "Password can not be null")
    @Size(message = "Password should be more than 4 and 20 characters", min = 4, max = 20)
    private String password;

    private Role role;
}
