package br.com.phc.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.phc.shoppingcart.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{

}
