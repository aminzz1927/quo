package com.quo.service.impl;

import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quo.annotation.Permission;
import com.quo.dto.ProductDto;
import com.quo.dto.ProductsDto;
import com.quo.entity.Product;
import com.quo.entity.ProductExport;
import com.quo.entity.ProductReport;
import com.quo.entity.ProductSeries;
import com.quo.entity.ProductSeries2;
import com.quo.entity.ProductType;
import com.quo.mapper.ProductMapper;
import com.quo.service.ProductService;

/** 

* @author zhoumin

*/
@Service("productService")
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductMapper pMapper;
	
	
	/*	@Override
		public List<ProductsDto> getProductList() {
			// TODO Auto-generated method stub
			return pMapper.getProductList();
		}*/

	
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
	public List<ProductSeries2> getSeriesList() {
		// TODO Auto-generated method stub
		return pMapper.getSeriesList();
	}


	
	@Override
	public boolean deleteProduct(Long pid) {
		// TODO Auto-generated method stub
		return pMapper.deleteProduct(pid);
	}


	@Override
	public boolean deleteProducts(Long[] pids) {
		// TODO Auto-generated method stub
		return pMapper.deleteProducts(pids);
	}


	
	@Override
	public boolean addProduct(Product product) {
		// TODO Auto-generated method stub
		return pMapper.addProduct(product);
	}

	
	/**
	 * author:韩宛廷
	 */
	@Override
	public boolean saves(List<ProductReport> productList) {
		
		return 	pMapper.saves(productList)==productList.size();
			
		}
/**
 * author:韩宛廷,产品导出
 */
	@Override
	public List<ProductExport> getByPids(Long[] pids) {
		
		return 	pMapper.getByPids(pids);
			
	}

	//获取产品
		@Override
		public Product getProductByPid(Long pid) {
			// TODO Auto-generated method stub
			return pMapper.getProductByPid(pid);
		}
		
		@Override
		public boolean updateStock(Long pid, Integer stock) {
			// TODO Auto-generated method stub
			return pMapper.updateStock(pid, stock);
		}
	}






