package com.quo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quo.dto.ProductsDto;
import com.quo.dto.StockInfoDto;
import com.quo.service.ProductService;
import com.quo.service.StockService;
import com.quo.utils.Result;
import com.quo.utils.ResultCode;

/** 

* @author zhoumin

*/
@Controller("stockController")
@RequestMapping(value="/api")
public class StockController {
	
	    @Autowired
	    public ProductService pService;
	    
	    @Autowired
	    public StockService stockService;
	
	  //在库一览					
	  @RequestMapping(value="/stock-list",method=RequestMethod.GET)
	  @ResponseBody 
	  public Result getStockList(){ 
		  
		  List<ProductsDto> stockList =	pService.getProductList(); 
		  Result result=new Result(ResultCode.SUCCESS);
		  result.setData(stockList);     
		  
		  return result;
	  
	  }
	  
	  
	  //出入库详情					
	  @RequestMapping(value="/stock-detail-list",method=RequestMethod.GET)
	  @ResponseBody 
	  public Result getStockInfoList(){ 
		  
		  List<StockInfoDto> stockInfoList = stockService.getStockInfoList(); 
		  Result result=new Result(ResultCode.SUCCESS);
		  result.setData(stockInfoList);     
		  
		  return result;
	  
	  }
	  
	  
	  
	  
	  
	  
	  
	  
	  
	

}
