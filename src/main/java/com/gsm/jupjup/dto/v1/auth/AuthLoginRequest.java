package com.gsm.jupjup.dto.v1.auth;

import com.gsm.jupjup.domain.AuthDomain;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthLoginRequest {

    private String email;
    private String password;

    public AuthDomain toEntity(){
        return AuthDomain.builder()
                .email(email)
                .password(password)
                .build();
    }

}
