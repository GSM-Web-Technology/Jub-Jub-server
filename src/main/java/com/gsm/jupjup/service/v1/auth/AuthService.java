package com.gsm.jupjup.service.v1.auth;

import com.gsm.jupjup.domain.AuthDomain;
import com.gsm.jupjup.dto.v1.auth.AuthLoginRequest;
import com.gsm.jupjup.dto.v1.auth.AuthSaveRequestDto;

public interface AuthService {
    void SignUpUser(AuthSaveRequestDto authSaveRequestDto);

    AuthDomain loginUser(AuthLoginRequest authLoginRequest) throws Exception;

}
