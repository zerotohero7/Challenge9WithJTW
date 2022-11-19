package com.example.Spring.Security.using.Spring.Data.JPA.MySQL.Spring.Boot.Configuration;

import com.example.Spring.Security.using.Spring.Data.JPA.MySQL.Spring.Boot.Configuration.MyUserDetails;
import com.example.Spring.Security.using.Spring.Data.JPA.MySQL.Spring.Boot.Entities.User;
import com.example.Spring.Security.using.Spring.Data.JPA.MySQL.Spring.Boot.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByEmail(userEmail);

        user.orElseThrow(() -> new UsernameNotFoundException("not found user with email : " + userEmail));

        return user.map(MyUserDetails::new).get();
    }
}