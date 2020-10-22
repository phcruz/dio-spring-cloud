package br.com.phc.shoppingcart.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "carrinho")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "carrinho_id")
	private Long id;

	@OneToMany
	@JoinTable(name = "carrinho_produto",
		joinColumns = @JoinColumn(name = "carrinho_id"),
		inverseJoinColumns = @JoinColumn(name = "produto_id"))
	private List<Product> items;

	public List<Product> getItems() {
		return Objects.isNull(items) ? new ArrayList<>() : items;
	}

}
