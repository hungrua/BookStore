package bookshop.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import bookshop.DTO.User;
import bookshop.service.IUserService;

@RestController
@CrossOrigin(origins = "*")
public class UserAPI {
	
	@Autowired
	IUserService userService;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@PostMapping("/user/add")
	public User addUser(@RequestBody User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		return userService.addNewUserOrAdmin(user);
	}
	
	@PostMapping("/user/login")
	public User checkUserRole(@RequestBody User user) {
		return userService.checkLogin(user);
	}
}
