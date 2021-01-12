package com.gsm.jupjup.service.v1.auth;

public interface JwtUtil {

    String createToken();

    void verifyToken(String givenToken);

}
