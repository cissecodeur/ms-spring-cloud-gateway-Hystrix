package com.cisse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.cisse.entities.ProductItem;


@RepositoryRestResource
public interface ProductItemRepository  extends JpaRepository<ProductItem, Long>{

}
