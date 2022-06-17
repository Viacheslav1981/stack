package ru.sli.stack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sli.stack.repository.User;
import ru.sli.stack.repository.UserRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {
    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ArrayList<String> rolesList = new ArrayList<>();
        User user = findByUsername(username);

        rolesList.add("ROLE_ADMIN");
        rolesList.add("ROLE_USER");

        if (user == null) {
            throw new UsernameNotFoundException(String.format("User '%s' not found", username));
        }

//        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
//                mapRolesToAuthorities(user.getRoles()));


        System.out.println(mapRolesToAuthorities(rolesList));

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                mapRolesToAuthorities(rolesList));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(ArrayList<String> rolesList) {

        return rolesList.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());

    }


}
