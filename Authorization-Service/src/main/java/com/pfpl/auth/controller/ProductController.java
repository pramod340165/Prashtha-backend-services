package com.pfpl.auth.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pfpl.auth.model.ProductModel;
import com.pfpl.auth.services.ProductService;


@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	ProductService productService;;

	private final Logger log = LoggerFactory.getLogger(ProductController.class);

	@PostMapping("/create")
	public ResponseEntity<List<ProductModel>> save(@RequestBody List<ProductModel> listProductModel) {
		try {
			List<ProductModel> listItemMasterModel = productService.Save(listProductModel);
			return new ResponseEntity<List<ProductModel>>(listItemMasterModel, HttpStatus.CREATED);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;

	}

	@GetMapping("/getall")
	public ResponseEntity<List<ProductModel>> getAllProduct() {
		try {
			List<ProductModel> listItemMasterModel = productService.getAllProducts();
			return new ResponseEntity<List<ProductModel>>(listItemMasterModel, HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;

	}

	@GetMapping("/{id}")
	public ResponseEntity<ProductModel> getProductById(@PathVariable int id) {
		try {
			ProductModel productModel = productService.getProductById(id);
			return new ResponseEntity<ProductModel>(productModel, HttpStatus.FOUND);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

}
