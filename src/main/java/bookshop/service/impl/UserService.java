package bookshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import bookshop.DTO.User;
import bookshop.converter.UserConverter;
import bookshop.entity.UserEntity;
import bookshop.repository.RoleRepository;
import bookshop.repository.UserRepository;
import bookshop.service.IUserService;
@Service
public class UserService implements IUserService{
	
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	UserConverter userConverter;
	@Autowired
	UserRepository userRepository;
	@Autowired
	AuthenticationManager authenticationManager;
	@Override
	public User addNewUserOrAdmin(User user) {
		UserEntity newUser = userConverter.toEntity(user);
		if(userRepository.findByUserName(user.getUserName())!=null) return new User();
		newUser.setRole(roleRepository.findOne(user.getRole_id()));
		return userConverter.toDTO(userRepository.save(newUser));
	}
	@Override
	public User checkLogin(User user) {
		try {
			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword()));
			SecurityContextHolder.getContext().setAuthentication(authentication);
			UserDetails userDetails = (UserDetails) authentication.getPrincipal();
			UserEntity entity = userRepository.findByUserName(userDetails.getUsername());
			User result =  userConverter.toDTO(entity);
			result.setEmail(null);
			result.setPassword(null);
			return result;
			
		}catch(Exception e) {
			return new User();
		}
	}

}
