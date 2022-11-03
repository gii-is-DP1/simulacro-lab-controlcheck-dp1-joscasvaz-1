package org.springframework.samples.petclinic.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "products")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	Integer id;
	
	@Size(min = 3, max = 50)
	@NotBlank
	@Column(name = "name")
	String name;
	
	@PositiveOrZero
	@NotBlank
	@Column(name = "price")
	double price;
	
	@ManyToOne
	@JoinColumn(name = "type")
	ProductType productType;
	
	public boolean isNew() {
		return this.id == null;
	}
}
