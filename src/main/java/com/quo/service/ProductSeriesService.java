package com.quo.service;

import java.util.List;


import com.quo.entity.Product;
import com.quo.entity.ProductSeries;
import com.quo.entity.ProductSeries2;

public interface ProductSeriesService {
	
	List<ProductSeries> getAll();
	
	ProductSeries2 getByPsid(int psid);
	
	boolean update(ProductSeries2 pd);
}
