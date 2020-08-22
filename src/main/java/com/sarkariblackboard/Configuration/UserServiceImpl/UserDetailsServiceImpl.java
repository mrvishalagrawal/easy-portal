package com.sarkariblackboard.Configuration.UserServiceImpl;


import java.util.ArrayList;
import java.util.List;

import com.sarkariblackboard.Configuration.UserEntity.Role;
import com.sarkariblackboard.Configuration.UserEntity.Users;
import com.sarkariblackboard.Configuration.UserRepository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        List<Users> usersList = usersRepository.findUser(userName);

        if (usersList != null && usersList.size() == 1) {
            Users users = usersList.get(0);

            List<String> roleList = new ArrayList<String>();
            for (Role role : users.getRoles()) {
                roleList.add(role.getRoleName());
            }

            return User.builder()
                    .username(users.getUsername())
                    //change here to store encoded password in db
                    .password( bCryptPasswordEncoder.encode(users.getPassword()) )
                    .disabled(users.isDisabled())
                    .accountExpired(users.isAccountExpired())
                    .accountLocked(users.isAccountLocked())
                    .credentialsExpired(users.isCredentialsExpired())
                    .roles(roleList.toArray(new String[0]))
                    .build();
        } else {
            throw new UsernameNotFoundException("User Name is not Found");
        }
    }
}