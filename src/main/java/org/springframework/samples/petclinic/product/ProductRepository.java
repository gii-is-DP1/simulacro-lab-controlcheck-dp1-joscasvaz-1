package org.springframework.samples.petclinic.product;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository
extends CrudRepository<Product, Integer> {
	
    List<Product> findAll();
    
    @Query(value = "SELECT ty FROM ProductType ty")
    List<ProductType> findAllProductTypes();
    
    @Query(value = "SELECT ty FROM ProductType ty WHERE ty.name LIKE:name")
    ProductType findProductType(@Param("name") String name);
    
    @Query(value = "SELECT p FROM Product p WHERE p.price <:price")
    List<Product> findProductsCheaperThan(@Param("price") Double price);
    
    Optional<Product> findById(int id);
    Product findByName(String name);
    Product save(Product p);
}
