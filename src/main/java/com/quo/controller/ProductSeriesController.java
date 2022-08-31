package com.quo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.quo.entity.Product;
import com.quo.entity.ProductSeries;
import com.quo.entity.ProductSeries2;
import com.quo.entity.Productdel;
import com.quo.exceptions.CommonException;
import com.quo.service.ProductSeriesService;
import com.quo.service.ProductService;
import com.quo.utils.Result;
import com.quo.utils.ResultCode;

/**
 * 
 * @author 韩宛廷
 *
 */
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
	
	 @RequestMapping(value="/product-series/{psid}",method = RequestMethod.DELETE)
	    public Result delete(@PathVariable(value="psid") int psid) {
	        psService.deleteById(psid);
	        return new Result(ResultCode.SUCCESS);
	    }
	
	 @RequestMapping(value="/product-series-del-enable",method = RequestMethod.GET) 
    public Result seriesDelEnable() {
    	List<Productdel> data=new ArrayList<>();
		List<ProductSeries> pslist=	psService.getAll();
		for (ProductSeries pro : pslist) {
			Productdel prodel=	new Productdel(pro.getPsid(), psService.getDelEnableByPsid(pro.getPsid()));
			data.add(prodel);
		}
		
		Result result=new Result(ResultCode.SUCCESS);
		result.setData(data);
		return result;
	}
	 
	 @RequestMapping(value="/product-series-del",method = RequestMethod.POST)
	    public Result seriesDelAll(@RequestBody  int[] psids) throws CommonException{
	
			psService.seriesDelAll(psids);
			
	        return new Result(ResultCode.SUCCESS);
	    }
	 
	    @RequestMapping(value="/product-series",method = RequestMethod.POST)
	    public Result save(@RequestBody ProductSeries2 productseries )  {
			/*
			 * ProductSeries2 ps2=new ProductSeries2(); ps2.setPsname(ps2.getPsname());
			 * ps2.setTid(ps2.getTid()); ps2.setNotes(ps2.getNotes());
			 */
	    	psService.save(productseries);
	        return new Result(ResultCode.SUCCESS);
	    }
	  
	  }
	


