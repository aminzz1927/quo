package com.quo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quo.entity.Product;
import com.quo.entity.ProductSeries;
import com.quo.entity.ProductSeries2;
import com.quo.mapper.ProductMapper;
import com.quo.mapper.ProductSeriesMapper;
import com.quo.service.ProductSeriesService;
import com.quo.service.ProductService;

@Service("productSeriesService")
public class ProductSeriesServiceImpl implements ProductSeriesService{

	@Autowired
	private ProductSeriesMapper psMapper;
	

	@Override
	public List<ProductSeries> getAll() {
		return psMapper.getAll();
	}


	@Override
	public ProductSeries2 getByPsid(int psid) {
		
		return psMapper.getByPsid(psid);
	}


	@Override
	public boolean update(ProductSeries2 pd) {
		return psMapper.update(pd)==1;
	}


	

}
