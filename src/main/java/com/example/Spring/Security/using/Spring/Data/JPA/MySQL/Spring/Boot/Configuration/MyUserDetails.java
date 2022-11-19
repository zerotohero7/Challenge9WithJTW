package com.example.Spring.Security.using.Spring.Data.JPA.MySQL.Spring.Boot.Configuration;

import com.example.Spring.Security.using.Spring.Data.JPA.MySQL.Spring.Boot.Entities.User;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
public class MyUserDetails implements UserDetails {


    private User user;



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_"+ user.getRole()));

/*        return user.getRole().stream()
                .map(role->new SimpleGrantedAuthority("ROLE_"+role)).collect(Collectors.toList());*/
    }
    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
