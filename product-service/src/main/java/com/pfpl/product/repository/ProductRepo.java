package com.pfpl.product.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pfpl.product.entity.ProductEntity;


@Repository
public interface ProductRepo extends CrudRepository<ProductEntity, Integer> {

	 

}
