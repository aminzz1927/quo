package com.quo.service;

import java.util.List;


import com.quo.entity.Product;
import com.quo.entity.ProductSeries;
import com.quo.entity.ProductSeries2;
import com.quo.exceptions.CommonException;
import com.quo.exceptions.LoginException;
/**
 * 
 * @author 韩宛廷
 *
 */

public interface ProductSeriesService {
	
	List<ProductSeries> getAll();
	
	ProductSeries2 getByPsid(int psid);
	
	boolean update(ProductSeries2 pd);
	
    boolean deleteById(int psid);
	
	boolean getDelEnableByPsid(int psid) ;
	
	void seriesDelAll(int[] psids) throws  CommonException;
	
	boolean save(ProductSeries2 ps2);
}
