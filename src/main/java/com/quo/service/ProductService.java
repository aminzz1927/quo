package com.quo.service;

import java.util.List;

import com.quo.dto.ProductDto;
import com.quo.dto.ProductsDto;
import com.quo.entity.Product;
import com.quo.entity.ProductSeries;
import com.quo.entity.ProductType;

public interface ProductService {

	List<ProductsDto> getProductList();

	ProductDto getProduct(Long pid);

	boolean updateProduct(Product product);

	List<ProductType> getTypeList();

	List<ProductSeries> getSeriesList();

	Product deleteProduct(Long pid);

	Product deleteProducts(Long pids);

	int addProduct(Product product);

}
