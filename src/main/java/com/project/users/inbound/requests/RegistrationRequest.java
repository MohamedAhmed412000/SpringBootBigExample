package com.project.users.inbound.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationRequest {

    @NotEmpty
    @Size(max = 100)
    private String firstname;

    @NotEmpty
    @Size(max = 100)
    private String lastname;

    @NotEmpty
    @Email
    @Size(max = 150)
    private String email;

    @NotEmpty
    @Size(min = 6, max = 16)
    private String password;

}
