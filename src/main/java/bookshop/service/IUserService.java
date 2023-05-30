package bookshop.service;

import bookshop.DTO.User;

public interface IUserService {
	User addNewUserOrAdmin(User user);
	User checkLogin(User user);
}
