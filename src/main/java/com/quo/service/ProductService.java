package com.quo.service;

import java.util.List;


import com.quo.dto.ProductDto;
import com.quo.dto.ProductsDto;
import com.quo.entity.Product;
import com.quo.entity.Product2;
import com.quo.entity.ProductExport;
import com.quo.entity.ProductSeries;
import com.quo.entity.ProductSeries2;
import com.quo.entity.ProductType;
import com.wkcto.crm.workbench.domain.Activity;
import com.wkcto.crm.workbench.service.String;

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

	boolean saves(List<Product2> productList);
	//产品导出
	List<ProductExport> getByPids(int[] pids);

	Product getProductByPid(Long pid);
}
