package pack.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pack.entity.User;

@Service
public class CustomUserDetailsService implements UserDetailsService {
@Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	System.out.println("username : " + username);
	
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
	String role = "";
	
	if (username.equals("guest")) {
		role = "ROLE_USER";
	} else if (username.equals("hellokitty")) {
		role = "ROLE_STAFF";
	} else if (username.equals("pompompurin")) {
		role = "ROLE_ADMIN";
	}
	
	User user = User.builder().id(1).userName(username).password(encoder.encode("1234")).email("@").role(role).build();
	List<GrantedAuthority> auth = new ArrayList<GrantedAuthority>();
	auth.add(new SimpleGrantedAuthority(user.getRole()));
	
	UserDetails ud = new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), auth);
	
	
	return null;
	}
}
