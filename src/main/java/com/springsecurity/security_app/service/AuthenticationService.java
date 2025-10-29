package com.springsecurity.security_app.service;

import com.springsecurity.security_app.dto.RegisterRequest;
import com.springsecurity.security_app.model.entity.User;
import com.springsecurity.security_app.model.enums.UserRole;
import com.springsecurity.security_app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity register(RegisterRequest request){
        if(userRepository.findByLogin(request.login()) != null){
            return ResponseEntity.badRequest().build();
        }
        String encryptedPassword = new BCryptPasswordEncoder().encode(request.password());
        User user = new User(null, request.login(), encryptedPassword, UserRole.USER);
        userRepository.save(user);
        return ResponseEntity.ok().build();
    }
}
