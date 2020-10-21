package br.com.phc.shoppingcart.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.phc.shoppingcart.exception.NotFoundException;
import br.com.phc.shoppingcart.model.Cart;
import br.com.phc.shoppingcart.model.Item;
import br.com.phc.shoppingcart.repository.CartRepository;

@Service
public class CartService {

	@Autowired
	private CartRepository cartRepository;
	
	public Optional<Cart> findByIdOptional(Long id) {
		return cartRepository.findById(id);
	}
	
	public Cart findById(Long id) {
		return cartRepository.findById(id).orElseThrow(() -> new NotFoundException("Not found cart id: " + id));
	}

	public Cart save(Long id, Item item) {
		Optional<Cart> savedCart = this.findByIdOptional(id);
		Cart cart = savedCart.isPresent() ? savedCart.get() : new Cart();
		cart.getItems().add(item);
		
		return cartRepository.save(cart);
	}

	public List<Cart> findAll() {
		return cartRepository.findAll();
	}

	public void deleteById(Long id) {
		Cart cart = this.findById(id);
		cartRepository.delete(cart);
	}

}
