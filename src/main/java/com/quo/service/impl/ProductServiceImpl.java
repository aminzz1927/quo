package com.quo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quo.dto.ProductDto;
import com.quo.dto.ProductsDto;
import com.quo.entity.Product;
import com.quo.entity.ProductSeries;
import com.quo.entity.ProductType;
import com.quo.mapper.ProductMapper;
import com.quo.service.ProductService;

@Service("productService")
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductMapper pMapper;
	
	
	@Override
	public List<ProductsDto> getProductList() {
		// TODO Auto-generated method stub
		return pMapper.getProductList();
	}


	@Override
	public ProductDto getProduct(Long pid) {
		// TODO Auto-generated method stub
		return pMapper.getProduct(pid);
	}


	@Override
	public boolean updateProduct(Product product) {
		// TODO Auto-generated method stub
		return pMapper.updateProduct(product);
	}


	@Override
	public List<ProductType> getTypeList() {
		// TODO Auto-generated method stub
		return pMapper.getTypeList();
	}


	@Override
	public List<ProductSeries> getSeriesList() {
		// TODO Auto-generated method stub
		return pMapper.getSeriesList();
	}


	@Override
	public Product deleteProduct(Long pid) {
		// TODO Auto-generated method stub
		return pMapper.deleteProduct(pid);
	}


	@Override
	public Product deleteProducts(Long pids) {
		// TODO Auto-generated method stub
		return pMapper.deleteProducts(pids);
	}


	@Override
	public int addProduct(Product product) {
		// TODO Auto-generated method stub
		return 0;
	}

}
