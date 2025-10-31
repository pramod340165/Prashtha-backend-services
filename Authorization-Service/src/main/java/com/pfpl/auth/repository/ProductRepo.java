package com.pfpl.auth.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pfpl.auth.entity.ProductEntity;
@Repository
public interface ProductRepo extends CrudRepository<ProductEntity, Integer> {

	 

}
