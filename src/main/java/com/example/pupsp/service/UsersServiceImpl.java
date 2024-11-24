package com.example.pupsp.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.pupsp.dto.UsersRegisterDTO;
import com.example.pupsp.entities.Users;
import com.example.pupsp.repository.UsersRepository;

@Service
public class UsersServiceImpl implements UsersService{

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public Users save(UsersRegisterDTO registroDTO) {
        Users user = new Users(registroDTO.getId(), registroDTO.getName(), registroDTO.getLastName(), registroDTO.getEmail(), registroDTO.getPassword(), registroDTO.getRegisterDate());
        return usersRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = usersRepository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("usuario o password invalidos");
        } 

        return new User(user.getEmail(), user.getPassword(),  new ArrayList<>()); 
    }


}
