package com.example.pupsp.security;

import org.springframework.security.crypto.password.PasswordEncoder;

public class PlainTextPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence rawPassword) {
        // No realiza ninguna codificación, retorna la contraseña tal cual
        return rawPassword.toString();
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        // Compara directamente el texto plano
        return rawPassword.toString().equals(encodedPassword);
    }

}
