package br.com.phc.productcatalog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.phc.productcatalog.exception.NotFoundException;
import br.com.phc.productcatalog.model.Product;
import br.com.phc.productcatalog.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public Product create(Product product) {
		return productRepository.save(product);
	}

	public Product findById(Long id) {
		return productRepository.findById(id).orElseThrow(() -> new NotFoundException("Not found product id: " + id));
	}

	public List<Product> findAll() {
		return productRepository.findAll();
	}
}
