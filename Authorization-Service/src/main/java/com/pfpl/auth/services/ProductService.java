package com.pfpl.auth.services;

import java.util.List;

import com.pfpl.auth.model.ProductModel;

public interface ProductService {

	List<ProductModel> Save(List<ProductModel> listProductModel);
	List<ProductModel> getAllProducts();
	ProductModel getProductById(int id);
}
