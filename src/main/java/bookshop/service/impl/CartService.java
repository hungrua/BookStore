package bookshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bookshop.entity.CartEntity;
import bookshop.repository.CartRepository;
import bookshop.repository.UserRepository;
import bookshop.service.ICartService;
@Service
public class CartService implements ICartService{

	@Autowired
	CartRepository cartRepository;
	@Autowired
	UserRepository userRepository;
	@Override
	public Long createCart(Long user_id) {
		CartEntity cart = new CartEntity();
		cart.setUser(userRepository.findOne(user_id));
		return cartRepository.save(cart).getId();
		
	}
	
}
