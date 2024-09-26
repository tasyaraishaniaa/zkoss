package user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import user.entity.UserLogin;
import user.repository.UserLoginRepository;

import java.util.Set;
import java.util.stream.Collectors;

@Service("userLoginService")
@Scope(value = "singleton", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserLoginServiceImpl implements UserDetailsService {

    @Autowired
    UserLoginRepository userLoginRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            UserLogin userLogin = userLoginRepository.get(username);
            Set<GrantedAuthority> authorities = userLogin.getRoles()
                    .stream()
                    .map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toSet());
            return new org.springframework.security.core.userdetails.User(userLogin.getUsername(), userLogin.getPassword(), authorities);
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw new RuntimeException("Invalid Login");
        }
    }
}
