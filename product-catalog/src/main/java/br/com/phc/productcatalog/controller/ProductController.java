package br.com.phc.productcatalog.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.phc.productcatalog.exception.StandardError;
import br.com.phc.productcatalog.model.Product;
import br.com.phc.productcatalog.service.ProductService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(path = "/api/v1/products")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@ApiOperation(value = "Create product")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Created", response = Product.class),
			@ApiResponse(code = 400, message = "Bad request", response = StandardError.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = StandardError.class),
			@ApiResponse(code = 403, message = "Forbidden", response = StandardError.class),
			@ApiResponse(code = 404, message = "Not found", response = StandardError.class),
			@ApiResponse(code = 500, message = "Internal server error", response = StandardError.class) })
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> create(@RequestBody Product product) {
		Product saveProduct = productService.create(product);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(saveProduct.getId())
				.toUri();
		
		return ResponseEntity.created(location).body(saveProduct);
	}
	
	@ApiOperation(value = "Find product by id")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK", response = Product.class),
			@ApiResponse(code = 400, message = "Bad request", response = StandardError.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = StandardError.class),
			@ApiResponse(code = 403, message = "Forbidden", response = StandardError.class),
			@ApiResponse(code = 404, message = "Not found", response = StandardError.class),
			@ApiResponse(code = 500, message = "Internal server error", response = StandardError.class) })
	@GetMapping(path = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable("id") Long id) {
		return ResponseEntity.ok().body(productService.findById(id));
	}
	
	@ApiOperation(value = "Find all product")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK", response = List.class),
			@ApiResponse(code = 400, message = "Bad request", response = StandardError.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = StandardError.class),
			@ApiResponse(code = 403, message = "Forbidden", response = StandardError.class),
			@ApiResponse(code = 404, message = "Not found", response = StandardError.class),
			@ApiResponse(code = 500, message = "Internal server error", response = StandardError.class) })
	@GetMapping
	public ResponseEntity<List<Product>> findAll() {
		return ResponseEntity.ok().body(productService.findAll());
	}
}
