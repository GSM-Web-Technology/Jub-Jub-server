package com.gsm.jupjup.dto.v1.auth;

import com.gsm.jupjup.domain.AuthDomain;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthSaveRequestDto {

    private String email;
    private String password;
    private String classNumber;
    private String name;

    public AuthDomain toEntity(){
        return AuthDomain.builder()
                .email(email)
                .password(password)
                .classNumber(classNumber)
                .name(name)
                .build();
    }

}
