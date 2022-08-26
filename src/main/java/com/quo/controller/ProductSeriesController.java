package com.quo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.quo.entity.Product;
import com.quo.entity.ProductSeries;
import com.quo.entity.ProductSeries2;
import com.quo.exceptions.CommonException;
import com.quo.service.ProductSeriesService;
import com.quo.service.ProductService;
import com.quo.utils.Result;
import com.quo.utils.ResultCode;

@RestController("productSeriesController")
@RequestMapping(value="/api")
public class ProductSeriesController {

	@Autowired
	public ProductSeriesService psService;

	@RequestMapping(value="/product-series",method=RequestMethod.GET)
	  public Result findAll() {
		List<ProductSeries> pslist=	psService.getAll();
	Result result=new Result(ResultCode.SUCCESS);
	System.out.println(pslist);
	result.setData(pslist);
	   return result;
	}
	  
	
	
	@RequestMapping(value="/product-series/{psid}",method = RequestMethod.GET)
    public Result findByPsid(@PathVariable(value="psid") int psid) {
       
       ProductSeries2 productseries= psService.getByPsid(psid);
        Result result = new Result(ResultCode.SUCCESS);
       result.setData(productseries);
       return result;
	
    }
	
	@RequestMapping(value = "/product-series/{psid}",method = RequestMethod.PUT)
    public Result update(@PathVariable(value="psid") int psid, @RequestBody ProductSeries2 productseries ) {
        //业务操作
		
		productseries.setPsid(psid);
		psService.update(productseries);
        return new Result(ResultCode.SUCCESS);
    }
	  
	  }
	 


