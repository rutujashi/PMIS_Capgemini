package com.productinfo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.productinfo.entity.Product;
import com.productinfo.service.ProductService;

@RestController
@RequestMapping("/productapi")
public class ProductController 
{
	@Autowired
	private ProductService productService;
	
//	@RequestMapping(method = RequestMethod.GET,path = "/allProducts")
	@GetMapping("/allProducts")
	public List<Product> fetchAllProducts()
	{
		return productService.getAllProducts();
	}
	
	@GetMapping("/{id}")
	public Optional<Product> fetchProductById(@PathVariable Integer id)
	{
		return Optional.ofNullable(productService.getProductById(id).orElseThrow());
	}
	
	@PostMapping("/addProduct")
	public Product insertProduct(@RequestBody Product product)
	{
		return productService.saveProduct(product);
	}
	
	@PutMapping("/updateProduct/{id}")
	public Product updateProductById(@PathVariable Integer id,@RequestBody Product productData)
	{
		Product product = productService.getProductById(id).orElseThrow();
		
		product.setName(productData.getName());
		product.setTagline(productData.getTagline());
		product.setPrice(productData.getPrice());
		
		return productService.saveProduct(product);
		
	}
	
	@DeleteMapping("/deleteProduct/{id}")
	public void deleteProduct(@PathVariable("id") Integer id)
	{
		productService.deleteProductById(id);
	}
}
