package br.com.phc.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.phc.shoppingcart.model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long>{

}
