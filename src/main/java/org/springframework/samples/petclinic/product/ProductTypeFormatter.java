package org.springframework.samples.petclinic.product;

import java.text.ParseException;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class ProductTypeFormatter implements Formatter<ProductType>{

	private ProductService service;
	
	@Autowired
	public ProductTypeFormatter(ProductService service) {
		this.service = service;
	}
	
    @Override
    public String print(ProductType type, Locale locale) {
        return String.format("[ProductType: %s]", type.getName());
    }

    @Override
    public ProductType parse(String text, Locale locale) throws ParseException {
    	
    	List<ProductType> types = service.findAllProductTypes();
    	
    	for(ProductType type:types) {
    		if(text.equals(type.getName())) return type;
    	}
    	
    	throw new ParseException("Product Type not valid: " + text, 0);
    }
    
}
