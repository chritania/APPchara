package com.conching.APPchara.Controllers;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.conching.APPchara.DTO.RegistrationRequest;
import com.conching.APPchara.Model.Role;
import com.conching.APPchara.Model.UserAuth;
import com.conching.APPchara.Repository.RoleRepository;
import com.conching.APPchara.Repository.UserAuthRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/auth")
public class UserAuthController{

    @Autowired
    UserAuthRepository userAuthRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;
    
    @PostMapping("/register")
    public ResponseEntity<?>register(@RequestBody RegistrationRequest registrationRequest) {
        
        //check if the username exist in DB
        if(userAuthRepository.existsByUsername(registrationRequest.getUsername())){
            return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);
        }
        if(userAuthRepository.existsByEmail(registrationRequest.getEmail())){
            return new ResponseEntity<>("An account is already registered in this email!", HttpStatus.BAD_REQUEST);
        }

        UserAuth user = new UserAuth(
            registrationRequest.getUsername(),
            registrationRequest.getEmail(),
            passwordEncoder.encode(registrationRequest.getPassword())
        );

        Role role = roleRepository.findByName("ROLE_ADMIN").get();
        user.setRoles(Collections.singleton(role));

        userAuthRepository.save(user);

        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
    }
    


}
