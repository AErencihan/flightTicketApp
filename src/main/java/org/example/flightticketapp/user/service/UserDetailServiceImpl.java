package org.example.flightticketapp.user.service;

import org.example.flightticketapp.user.model.User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserService userService;

    public UserDetailServiceImpl(UserService userService){
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findUserByUserName(username);

        var roles = Stream.of(user.getRole())
                .map(x-> new SimpleGrantedAuthority(x.name()))
                .toList();

        return new org.springframework.security.core
                .userdetails
                .User(user.getName(), user.getPassword(),roles);
    }
}
