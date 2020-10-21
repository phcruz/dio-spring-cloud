package br.com.phc.productcatalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.phc.productcatalog.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
