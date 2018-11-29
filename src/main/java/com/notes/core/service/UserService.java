package com.notes.core.service;

import com.notes.core.entity.UserEntity;
import com.notes.core.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
public class UserService implements UserDetailsService {

    @Autowired
    @Qualifier("userRepository")
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUserName(username);
        return new User(user.getUserName(), user.getPassword(), user.isActive(), user.isActive(), user.isActive(), user.isActive(), buildGranted(user.getRol()));
    }

    public List<GrantedAuthority> buildGranted(byte rol) {
        String[] roles = {"READER", "USER", "ADMINISTRATOR"};
        List<GrantedAuthority> auths = new ArrayList<>();
        for(int i = 0; i < rol; i++) {
            auths.add(new SimpleGrantedAuthority(roles[i]));
        }
        return auths;
    }
}
