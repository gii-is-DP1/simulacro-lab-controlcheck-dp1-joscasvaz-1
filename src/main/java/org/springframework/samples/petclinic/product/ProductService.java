package org.springframework.samples.petclinic.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {
	
	private ProductRepository repo;
	
	@Autowired
	public ProductService(ProductRepository repo) {
		this.repo = repo;
	}
	
	@Transactional(readOnly = true)
    public List<Product> getAllProducts(){
        return repo.findAll();
    }
	
	@Transactional(readOnly = true)
    public List<Product> getProductsCheaperThan(double price) {
        return repo.findProductsCheaperThan(price);
    }
	
	@Transactional(readOnly = true)
    public ProductType getProductType(String typeName) {
        return repo.findProductType(typeName);
    }
	
	@Transactional
	public List<ProductType> findAllProductTypes() {
		return repo.findAllProductTypes();
	}
	
	@Transactional
    public Product save(Product p){
        return repo.save(p);
    }

}
