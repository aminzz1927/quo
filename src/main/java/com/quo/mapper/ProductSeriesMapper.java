package com.quo.mapper;

import java.util.List;




import org.springframework.stereotype.Repository;

import com.quo.entity.Product;
import com.quo.entity.ProductSeries;
import com.quo.entity.ProductSeries2;

/**
 * 
 * @author 韩宛廷
 *
 */


@Repository
public interface ProductSeriesMapper {
	List<ProductSeries> getAll();

	
	ProductSeries2 getByPsid(int psid);
	
	int update(ProductSeries2  pd);
	
    int deleteById(int psid);
	
	List<Product>  getProductByPsid(int psid);
	
	 boolean deleteByIds(int[] psids);
	
	 List<Product>  getProductByPsids(int[] psids);
	 
	 int save(ProductSeries2 ps2);
	
}
