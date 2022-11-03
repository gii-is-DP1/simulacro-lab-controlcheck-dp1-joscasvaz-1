package org.springframework.samples.petclinic.product;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {
    
	private ProductService service;
	private static final String CREATE_OR_UPDATE_FORM =
			"/products/createOrUpdateForm";
	
	@Autowired
	public ProductController(ProductService service) {
		this.service = service;
	}
	
	@Transactional
	@GetMapping(value = "/product/create")
	public String initCreateOrUpdateForm(Map<String, Object> model) {
		
		List<String> typesName = service.findAllProductTypes().stream()
				.map(ProductType::getName)
				.toList();
		model.put("types", typesName);
		
		Product product = new Product();
		model.put("product", product);
		
		return CREATE_OR_UPDATE_FORM;
	}
	
	@Transactional
	@PostMapping(value = "/product/create")
	public String createOrUpdate(Product product, BindingResult result) {
		
		if (result.hasErrors()) {
			
			return CREATE_OR_UPDATE_FORM;
			
		} else {
			
			this.service.save(product);
			return "redirect:/";
		}
	}
	
}
