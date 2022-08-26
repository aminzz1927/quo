package com.quo.mapper;

import java.util.List;


import org.springframework.stereotype.Repository;

import com.quo.entity.ProductSeries;
import com.quo.entity.ProductSeries2;




@Repository
public interface ProductSeriesMapper {
	List<ProductSeries> getAll();

	
	ProductSeries2 getByPsid(int psid);
	
	int update(ProductSeries2  pd);
}
