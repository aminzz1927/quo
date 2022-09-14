package com.quo.service;

import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;

import com.quo.dto.ProductDto;
import com.quo.dto.ProductsDto;
import com.quo.entity.Product;
import com.quo.entity.ProductExport;
import com.quo.entity.ProductReport;
import com.quo.entity.ProductSeries;
import com.quo.entity.ProductSeries2;
import com.quo.entity.ProductType;

/** 

* @author zhoumin

*/
public interface ProductService {

	List<ProductsDto> getProductList();

	ProductDto getProduct(Long pid);

	boolean updateProduct(Product product);

	List<ProductType> getTypeList();

	List<ProductSeries2> getSeriesList();

	boolean deleteProduct(Long pid);

	boolean deleteProducts(Long[] pids);

	boolean addProduct(Product product);

	boolean saves(List<ProductReport> productList);
	//产品导出
	List<ProductExport> getByPids(Long[] pids);

	Product getProductByPid(Long pid);

	boolean updateStock(Long pid, Integer stock);
	
}

