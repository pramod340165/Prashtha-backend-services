package com.pfpl.product.services;

import java.util.List;

import com.pfpl.product.model.ProductModel;


public interface ProductService {

	List<ProductModel> Save(List<ProductModel> listProductModel);
	List<ProductModel> getAllProducts();
	ProductModel getProductById(int id);
}
