package br.com.phc.shoppingcart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.phc.shoppingcart.exception.StandardError;
import br.com.phc.shoppingcart.model.Cart;
import br.com.phc.shoppingcart.model.Item;
import br.com.phc.shoppingcart.service.CartService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(path = "/api/v1/carts")
public class CartController {

	@Autowired
	private CartService cartService;
	
	@ApiOperation(value = "Create cart")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Created", response = Cart.class),
			@ApiResponse(code = 400, message = "Bad request", response = StandardError.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = StandardError.class),
			@ApiResponse(code = 403, message = "Forbidden", response = StandardError.class),
			@ApiResponse(code = 404, message = "Not found", response = StandardError.class),
			@ApiResponse(code = 500, message = "Internal server error", response = StandardError.class) })
	@PostMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cart> create(@PathVariable("id") Long id, @RequestBody Item item) {
		return ResponseEntity.ok().body(cartService.save(id, item));
	}

	@ApiOperation(value = "Find cart by id")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK", response = Cart.class),
			@ApiResponse(code = 400, message = "Bad request", response = StandardError.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = StandardError.class),
			@ApiResponse(code = 403, message = "Forbidden", response = StandardError.class),
			@ApiResponse(code = 404, message = "Not found", response = StandardError.class),
			@ApiResponse(code = 500, message = "Internal server error", response = StandardError.class) })
	@GetMapping(path = "/{id}")
	public ResponseEntity<Cart> findById(@PathVariable("id") Long id) {
		return ResponseEntity.ok().body(cartService.findById(id));
	}
	
	@ApiOperation(value = "Find all carts")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK", response = List.class),
			@ApiResponse(code = 400, message = "Bad request", response = StandardError.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = StandardError.class),
			@ApiResponse(code = 403, message = "Forbidden", response = StandardError.class),
			@ApiResponse(code = 404, message = "Not found", response = StandardError.class),
			@ApiResponse(code = 500, message = "Internal server error", response = StandardError.class) })
	@GetMapping
	public ResponseEntity<List<Cart>> findAll() {
		return ResponseEntity.ok().body(cartService.findAll());
	}
	
	@ApiOperation(value = "Delete cart by id")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK", response = Void.class),
			@ApiResponse(code = 400, message = "Bad request", response = StandardError.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = StandardError.class),
			@ApiResponse(code = 403, message = "Forbidden", response = StandardError.class),
			@ApiResponse(code = 404, message = "Not found", response = StandardError.class),
			@ApiResponse(code = 500, message = "Internal server error", response = StandardError.class) })
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
		return ResponseEntity.noContent().build();
	}
}
