package com.gsm.jupjup.service.v1.auth;

import com.gsm.jupjup.domain.AuthDomain;

public interface AuthService {
    void SignUpUser(AuthDomain authDomain);

    AuthDomain loginUser(String id, String password) throws Exception;
}
