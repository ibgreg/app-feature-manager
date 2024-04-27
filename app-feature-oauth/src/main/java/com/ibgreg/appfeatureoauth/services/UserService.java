package com.ibgreg.appfeatureoauth.services;

import com.ibgreg.appfeatureoauth.entities.User;
import com.ibgreg.appfeatureoauth.feignclients.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserFeignClient userFeignClient;

    public User findByEmail(String email) {
        User user = userFeignClient.findUserByEmail(email).getBody();

        if (user == null) {
            throw new IllegalArgumentException("Email not found");
        }

        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userFeignClient.findUserByEmail(username).getBody();

        if (user == null) {
            throw new UsernameNotFoundException("Email not found");
        }

        return user;
    }
}
