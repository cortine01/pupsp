package com.example.pupsp.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.pupsp.dto.UsersRegisterDTO;
import com.example.pupsp.entities.Users;

public interface UsersService extends UserDetailsService{
    public Users save(UsersRegisterDTO registroDTO);
}
