package com.quo.service.impl;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quo.entity.Product;
import com.quo.entity.ProductSeries;
import com.quo.entity.ProductSeries2;
import com.quo.exceptions.CommonException;
import com.quo.exceptions.LoginException;
import com.quo.mapper.ProductMapper;
import com.quo.mapper.ProductSeriesMapper;
import com.quo.service.ProductSeriesService;
import com.quo.service.ProductService;
import com.quo.utils.ResultCode;

/**
 * 
 * @author 韩宛廷
 *
 */
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


	@Override
	public boolean deleteById(int psid) {
		return psMapper.deleteById(psid) == 1;
	}


	@Override
	public boolean getDelEnableByPsid(int psid){
		ProductSeries2 ps2= psMapper.getByPsid(psid);
		List<Product> pros=psMapper.getProductByPsid(psid);
		if(ps2!=null) {
			if(pros.size()==0) {
				 return true;
			}else {
				return false;
			}
		} else {
			return false;
		}
		
	}		
		
	
	public void seriesDelAll(int[] psids)  throws CommonException{
		boolean result = true;
		for (int i : psids) {
			if(!getDelEnableByPsid(i)) {
				result = false;
				break;
			}
		}
		
		if(result) {
			psMapper.deleteByIds(psids);
		} else {
			throw new CommonException(ResultCode.FAIL);
		}
	
	}


	@Override
	public boolean save(ProductSeries2 ps2) {
		
		return 	psMapper.save(ps2)==1;
	
	}
}	
		
	
	


	


