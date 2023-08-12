package com.koscom.hackathon1.utility;

import com.koscom.hackathon1.domain.UserInfo;
import com.koscom.hackathon1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomLoadUserByUsername implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
        UserInfo userInfo = userRepository.findBy(loginId);

        if(userInfo == null) {
            throw new UsernameNotFoundException("Not Found User");
        }

        return userInfo;
    }

}