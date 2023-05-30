package bookshop.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import bookshop.entity.UserEntity;
import bookshop.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity user = userRepository.findByUserName(username);
		if(user!=null) {
			List<GrantedAuthority> grandList = new ArrayList<GrantedAuthority>();
			GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole().getRole_code());
			grandList.add(authority);
			UserDetails myUser = (UserDetails) new User(username,user.getPassword(),grandList);
			return myUser;
		}
		return null;
	}
}
