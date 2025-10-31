package com.pfpl.auth.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfpl.auth.entity.ProductEntity;
import com.pfpl.auth.model.ProductModel;
import com.pfpl.auth.repository.ProductRepo;
import com.pfpl.auth.util.IterableToList;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepo productRepo;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public List<ProductModel> Save(List<ProductModel> listProductModel) {

		try {
			ProductEntity productEntity = null;
			ProductModel productModel = null;
			List<ProductEntity> listProductEntities = new ArrayList<ProductEntity>();

			for (ProductModel prodModel : listProductModel) {
				productEntity = modelMapper.map(prodModel, ProductEntity.class);
				listProductEntities.add(productEntity);
			}

			listProductEntities = (List<ProductEntity>) productRepo.saveAll(listProductEntities);

			for (ProductEntity prodEntity : listProductEntities) {
				listProductModel = new ArrayList<ProductModel>();
				productModel = modelMapper.map(prodEntity, ProductModel.class);
				listProductModel.add(productModel);
			}
			return listProductModel;
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return listProductModel;
	}

	@Override
	public List<ProductModel> getAllProducts() {
		try {
			Iterable<ProductEntity> iterable = productRepo.findAll();
			List<ProductEntity> listProduct = IterableToList.convertIterableToListUsingStreams(iterable);
			List<ProductModel>  listProductModel = new ArrayList<ProductModel>();

			for (ProductEntity prodEntity : listProduct) {
				
				ProductModel productModel = modelMapper.map(prodEntity, ProductModel.class);
				listProductModel.add(productModel);
			}
			return listProductModel;
		} catch (Exception ex) {

			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public ProductModel getProductById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
