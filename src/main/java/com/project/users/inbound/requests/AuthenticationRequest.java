package com.project.users.inbound.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class AuthenticationRequest {

    @NotEmpty
    @Email
    @Size(max = 150)
    private String email;

    @NotEmpty
    @Size(min = 6, max = 16)
    private String password;

}
